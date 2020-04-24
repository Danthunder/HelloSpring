package com.tutorialspring.other;


import java.util.concurrent.locks.LockSupport;


/**
 * @description: TODO
 * @author: Wang danning
 * @create: 2020-01-01 20:17
 * @version: 1.0
 **/

public class MutiThread_LockSupport {

    static Thread printDigitThread = null, printCharThread = null;
    public static void main(String... args) throws InterruptedException {
        final String[] digitSeq = new String[]{"1","2","3","4","5"};
        final String[] charseq = new String[]{"A","B","C","D","E"};
        printDigitThread = new Thread(() -> {
            for (String str : digitSeq) {
                System.out.print(str);
                while (!printCharThread.isAlive()) {
                    System.out.println("线程printCharThread未启动！");
                }
                LockSupport.unpark(printCharThread);
                LockSupport.park();
            }
        });

        printCharThread = new Thread(() -> {
            for (String str : charseq) {
                LockSupport.park();
                System.out.print(str);
                LockSupport.unpark(printDigitThread);
            }
        });
        printDigitThread.start();
        Thread.sleep(1);
        printCharThread.start();
    }
}
