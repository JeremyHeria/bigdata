package com.heria.onoroff;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DistributeClient {

    private String connectString = "master:2181,slave1:2181,slave2:2181";
    private int sessionTimeout= 2000;
    private ZooKeeper zk;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        DistributeClient client = new DistributeClient();
        
        //获取zookeeper连接
        client.getConnect();

        //监听
        client.getServerList();

        //休眠
        client.business();

    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }


    private void getConnect() throws IOException {

        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

                try {
                    getServerList();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (KeeperException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void getServerList() throws InterruptedException, KeeperException {
        List<String> children = zk.getChildren("/servers", true);

        ArrayList<String> servers = new ArrayList<>();

        for (String child : children) {
            byte[] data = zk.getData("/servers/" + child, false, null);

            servers.add(new String(data));
        }
        System.out.println(servers);
    }
}
