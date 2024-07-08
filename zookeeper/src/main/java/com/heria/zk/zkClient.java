package com.heria.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class zkClient {
    private String connectString = "master:2181,slave1:2181,slave2:2181";
    private int sessionTimeout = 5000;
    private ZooKeeper zkClient;

    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("-------------------------");
                List<String> children = null;
                try {
                    children = zkClient.getChildren("/", true);
                    for (String child : children) {
                        System.out.println(child);
                    }
                    System.out.println("-------------------------");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Test
    public void create() throws InterruptedException, KeeperException {
        String nodeCreated = zkClient.create("/bigdata", "heria.s".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);


    }
    @Test
    public void getChildren() throws InterruptedException, KeeperException {
        List<String> children = zkClient.getChildren("/", true);

        //—” ±
        Thread.sleep(Long.MAX_VALUE);

    }

    @Test
    public void exist() throws InterruptedException, KeeperException {

        Stat stat = zkClient.exists("/bigdata", false);

        System.out.println(stat==null?"not exist":"exist");
    }
}

