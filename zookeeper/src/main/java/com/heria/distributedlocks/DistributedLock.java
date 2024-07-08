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
    //等待前一个步骤执行完后在开始
    private CountDownLatch waitLatch=new CountDownLatch(1);

    private String waitPath;
    private String currentMode;

    public DistributedLock() throws IOException, InterruptedException, KeeperException {

        //获取链接
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //connectLatch 如果连接上zk，可以释放
                if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
                    connectLatch.countDown();
                }

                //waitLatch需要释放(节点被删除并且被删除的是前一个节点)
                if(watchedEvent.getType()== Event.EventType.NodeDeleted && watchedEvent.getPath().equals(waitPath)){
                    waitLatch.countDown();
                }

            }
        });
        //等待zk正常连接，往下走程序
        connectLatch.await();

        //判断节点/locks是否存在
        Stat stat = zk.exists("/locks", false);

        if(stat== null){
            //创建一下根节点
            zk.create("/locks","locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

    }

    //对zk加锁
    public void zklock(){

        //创建对应的临时带序号的节点

        try {
            currentMode = zk.create("/locks/" + "seq-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            //判断创建的节点是否是最小的序号节点
            List<String> children = zk.getChildren("/locks", false);
            //如果创建的节点只有一个值，就直接获取到锁，如果不是，监听他前一个节点
            if(children.size()==1){
                return;
            }else {
                Collections.sort(children);

                //获取节点名称
                String thisNode = currentMode.substring("/locks/".length());
                //通过名称获取该结点在children的位置
                int index = children.indexOf(thisNode);
                //判断
                if(index==-1){
                    System.out.println("数据异常");
                }else if (index==0){
                    //就一个节点，可以获取锁
                    return;
                }
                else{
                    //需要监听前一个节点变化
                    waitPath="/locks/"+children.get(index-1);
                    zk.getData(waitPath,true,null);

                    //等待监听
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
    //对zk加锁
    public void unZklock() throws InterruptedException, KeeperException {

        //删除节点
        zk.delete(currentMode, -1);
    }


}


