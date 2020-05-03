package com.jyp.studydemo.main;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/5/1 19:47
 * @description：直接内存溢出OOM测试  -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;


    public static void main(String[] args) throws Exception{
        Field unsafefField = Unsafe.class.getDeclaredFields()[0];
        unsafefField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafefField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }

}
