package com.heria.onoroff;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DistributeServer {


    private ZooKeeper zk;
    private String connectString;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        DistributeServer server = new DistributeServer();
        //1.获取连接
        server.getConnect();

        //2.注册服务器到zookeeper集群
        server.regist(args[0]);

        //休眠
        server.business();
    }




    private void getConnect() throws IOException {

        connectString = "master:2181,slave1:2181,slave2:2181";
        int sessionTimeout =2000;
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
    }


    private void regist(String hostname) throws InterruptedException, KeeperException {
        String create = zk.create("/servers/"+hostname, hostname.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        System.out.println(hostname+" is online");
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }
}
