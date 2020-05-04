package com.jyp.studydemo.gc;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/5/3 18:27
 * @description：测试GC并学习阅读GC日志
 */
public class TestGc {


    private static final int _1MB = 1024 * 1024;

    public static void testAllocation(){
    /*
    -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:PrintGCDetails -XX:SurvivorRatio=8
     */

        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }


    public static void testPretenureSizeThreshold(){
        /**
         * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
         *
         * -XX:PretenureSizeThreshold 对Parallel Scavenge收集器无效，只对Serial和ParNew收集器有效
         */
        byte[] allocation;
        allocation = new byte[9 * _1MB];


        /* gc日志打印：
           Heap
             PSYoungGen      total 9216K, used 7094K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
              eden space 8192K, 86% used [0x00000000ff600000,0x00000000ffced980,0x00000000ffe00000)
              from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
              to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
             ParOldGen       total 10240K, used 0K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
              object space 10240K, 0% used [0x00000000fec00000,0x00000000fec00000,0x00000000ff600000)
             Metaspace       used 3215K, capacity 4496K, committed 4864K, reserved 1056768K
              class space    used 348K, capacity 388K, committed 512K, reserved 1048576K

         */
    }

    public static void main(String[] args){
//        testAllocation();
        testPretenureSizeThreshold();
    }
}
