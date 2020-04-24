package com.tutorialspring.other;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: TODO
 * @author: Wang danning
 * @create: 2020-01-01 20:17
 * @version: 1.0
 **/

public class MutiThread_ReentrantLock {

    private static Thread printDigitThread = null, printCharThread = null;
    private static volatile boolean digitDoneFlag = false;
    private static volatile boolean charDoneFlag = false;

    public static void main(String... args) throws InterruptedException {
        final String[] digitSeq = new String[]{"1","2","3","4","5"};
        final String[] charSeq = new String[]{"A","B","C","D","E"};

        final CountDownLatch latch = new CountDownLatch(1);
        final ReentrantLock myLock = new ReentrantLock();
        final Condition condition = myLock.newCondition();

        printDigitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                myLock.lock();
                try {
                    for (String str : digitSeq) {
                        System.out.print(str);
                        digitDoneFlag = true; // 打印数字完毕
                        charDoneFlag = false; // 打印字母未完成
                        latch.countDown();
                        condition.signal(); // 唤醒打印字母的线程进入Entry队列
                        // 防止虚假唤醒
                        while (!charDoneFlag) {
                            condition.await(); // 让出锁
                        }
                    }
                    digitDoneFlag = true;
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    myLock.unlock();
                }
            }
        },"t1");

        printCharThread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    // 防止虚假唤醒
                    while(latch.getCount() != 0) {
                        latch.await();
                    }
                    myLock.lock();
                    for (String str : charSeq) {
                        System.out.print(str);
                        charDoneFlag = true;
                        digitDoneFlag = false;
                        condition.signal();
                        // 防止虚假唤醒
                        while(!digitDoneFlag) {
                            condition.await();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    myLock.unlock();
                }
            }
        },"t2");

        printDigitThread.start();
        Thread.sleep(100);
        printCharThread.start();
    }
}
