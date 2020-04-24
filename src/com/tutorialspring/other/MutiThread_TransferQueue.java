package com.tutorialspring.other;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TransferQueue;

/**
 * @program: HelloSpring.com.tutorialspring.other.MutiThread_TransferQueue
 * @description: TODO
 * @author: Wang danning
 * @create: 2020-01-02 23:16
 * @version: 1.0
 **/

public class MutiThread_TransferQueue {
    private static Thread printDigitThread = null, printCharThread = null;

    public static void main(String... args) {
        final String[] digitSeq = new String[]{"1","2","3","4","5"};
        final String[] charSeq = new String[]{"A","B","C","D","E"};

        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();

        printCharThread = new Thread(()->{
            try {
                for (String str : digitSeq) {
                    transferQueue.transfer(str);
                    System.out.print(transferQueue.take()); // take从队列中拿元素，阻塞方法
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        printDigitThread = new Thread(()->{
            try {
                for (String str : charSeq) {
                    System.out.print(transferQueue.take());
                    transferQueue.transfer(str);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        printDigitThread.start();
        printCharThread.start();
    }
}
