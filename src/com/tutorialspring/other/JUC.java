package com.tutorialspring.other;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TransferQueue;

/**
 * @program: HelloSpring.com.tutorialspring.other.JUC
 * @description: TODO
 * @author: Wang danning
 * @create: 2019-12-21 11:49
 * @version: 1.0
 **/
public class JUC {
//    volatile int j;

//    public void syncBlock(){
//        synchronized (this){
//            System.out.println("hello block");
//        }
//    }
//    public synchronized void syncMethod(){
//        System.out.println("hello method");
//    }

//    public static String s1 = "static";


    private static final int _1MB = 10 * 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];  // 出现一次Minor GC
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    @SuppressWarnings("unused")
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //直接分配在老年代中
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     * -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];  // 什么时候进入老年代决定于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M
     * -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     * -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];   // allocation1+allocation2大于survivo空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
     */
    @SuppressWarnings("unused")
    public static void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8 -XX:+UseParallelGC -XX:+UseParallelOldGC
     */
    @SuppressWarnings("unused")
    public static void testParalellGC() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];

//        allocation4 = new byte[4 * _1MB];
        allocation5 = new byte[1 * _1MB];
        allocation6 = new byte[3 * _1MB];

    }

    public static void main(String... args) {
//        System.gc();
//        testAllocation();
//        testPretenureSizeThreshold();
//        testTenuringThreshold();
//        testTenuringThreshold2();
        testParalellGC();

//        String s1 = new String("he") +
//                new String("llo");
//
//        s1.intern();
//        String s2 = "hello";
//        System.out.println(s1==s2);
//        String a = "aa";
//        String b = new String("aa");
//        String c = b.intern();
//        System.out.println(a == c);

//        SyncTest();

//        Object o = new Object();
//        synchronized(o) {
//            System.out.println();
//        }
//        ExecutorService t = Executors.newCachedThreadPool();
//        TransferQueue

    }
}
