package com.heria.distributedlocks;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

public class DistributedLockTest {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        final DistributedLock lock1 = new DistributedLock();
        final DistributedLock lock2 = new DistributedLock();
        new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    lock1.zklock();
                    System.out.println("�߳�1��������ȡ����");
                    Thread.sleep(5*1000);
                    lock1.unZklock();
                    System.out.println("�߳�1�ͷ���");
                } catch (InterruptedException | KeeperException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    lock2.zklock();
                    System.out.println("�߳�2��������ȡ����");
                    Thread.sleep(5 * 1000);
                    lock2.unZklock();
                    System.out.println("�߳�2�ͷ���");
                } catch (InterruptedException | KeeperException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
