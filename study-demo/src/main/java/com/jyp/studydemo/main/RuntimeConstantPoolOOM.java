package com.jyp.studydemo.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/5/1 17:51
 * @description：${description}
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
