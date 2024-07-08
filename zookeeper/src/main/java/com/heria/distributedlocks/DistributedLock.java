package com.heria.distributedlocks;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DistributedLock {
    private final String connectString="master:2181,slave1:2181,slave2:2181";
    private final int sessionTimeout=2000;
    private final ZooKeeper zk;
    private CountDownLatch connectLatch=new CountDownLatch(1);
    //�ȴ�ǰһ������ִ������ڿ�ʼ
    private CountDownLatch waitLatch=new CountDownLatch(1);

    private String waitPath;
    private String currentMode;

    public DistributedLock() throws IOException, InterruptedException, KeeperException {

        //��ȡ����
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //connectLatch ���������zk�������ͷ�
                if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
                    connectLatch.countDown();
                }

                //waitLatch��Ҫ�ͷ�(�ڵ㱻ɾ�����ұ�ɾ������ǰһ���ڵ�)
                if(watchedEvent.getType()== Event.EventType.NodeDeleted && watchedEvent.getPath().equals(waitPath)){
                    waitLatch.countDown();
                }

            }
        });
        //�ȴ�zk�������ӣ������߳���
        connectLatch.await();

        //�жϽڵ�/locks�Ƿ����
        Stat stat = zk.exists("/locks", false);

        if(stat== null){
            //����һ�¸��ڵ�
            zk.create("/locks","locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

    }

    //��zk����
    public void zklock(){

        //������Ӧ����ʱ����ŵĽڵ�

        try {
            currentMode = zk.create("/locks/" + "seq-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            //�жϴ����Ľڵ��Ƿ�����С����Žڵ�
            List<String> children = zk.getChildren("/locks", false);
            //��������Ľڵ�ֻ��һ��ֵ����ֱ�ӻ�ȡ������������ǣ�������ǰһ���ڵ�
            if(children.size()==1){
                return;
            }else {
                Collections.sort(children);

                //��ȡ�ڵ�����
                String thisNode = currentMode.substring("/locks/".length());
                //ͨ�����ƻ�ȡ�ý����children��λ��
                int index = children.indexOf(thisNode);
                //�ж�
                if(index==-1){
                    System.out.println("�����쳣");
                }else if (index==0){
                    //��һ���ڵ㣬���Ի�ȡ��
                    return;
                }
                else{
                    //��Ҫ����ǰһ���ڵ�仯
                    waitPath="/locks/"+children.get(index-1);
                    zk.getData(waitPath,true,null);

                    //�ȴ�����
                    waitLatch.await();
                    return;
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    //��zk����
    public void unZklock() throws InterruptedException, KeeperException {

        //ɾ���ڵ�
        zk.delete(currentMode, -1);
    }


}


