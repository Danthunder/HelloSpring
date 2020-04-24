package com.tutorialspring.other;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: HelloSpring.com.tutorialspring.other.MutiThread_WaitNotify
 * @description: TODO
 * @author: Wang danning
 * @create: 2020-01-01 20:17
 * @version: 1.0
 **/

public class MutiThread_WaitNotify {

    private static Thread printDigitThread = null, printCharThread = null;
    private static volatile boolean digitDoneFlag = false;
    private static volatile boolean charDoneFlag = false;
    public static void main(String... args) throws InterruptedException {
        final String[] digitSeq = new String[]{"1","2","3","4","5"};
        final String[] charSeq = new String[]{"A","B","C","D","E"};

        final CountDownLatch latch = new CountDownLatch(1);

        final Object o = new Object();

        printDigitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        for (String str : digitSeq) {
                            System.out.print(str);
//                            latch.countDown();
                            digitDoneFlag = true;
                            charDoneFlag = false;
                            o.notify();
                            // 防止虚假唤醒
                            while (!charDoneFlag) {
                                o.wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    digitDoneFlag = true;
                    o.notify();
                }
            }
        },"t1");

        printCharThread = new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    latch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (o) {
                    try {
                        // 保证先执行数字打印
                        while (!digitDoneFlag) {
                            o.wait();
                        }
                        for (String str : charSeq) {
                            System.out.print(str);
                            charDoneFlag = true;
                            digitDoneFlag = false;
                            o.notify();
                            while(!digitDoneFlag) {
                                o.wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t2");

        printDigitThread.start();
//        Thread.sleep(1000);
        printCharThread.start();
    }
}
