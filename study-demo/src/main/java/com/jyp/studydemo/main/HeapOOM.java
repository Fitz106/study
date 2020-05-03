package com.jyp.studydemo.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/5/1 16:51
 * @description：Java堆内存溢出测试   -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {

    }
    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
