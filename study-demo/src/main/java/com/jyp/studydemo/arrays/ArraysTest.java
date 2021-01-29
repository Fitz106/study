package com.jyp.studydemo.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/11/30 9:30
 * @description：${description}
 */
public class ArraysTest {
    public static void main(String[] args){
//        Integer[] a_Integer= new Integer[] { 1, 2, 3, 4 };
//        List a_Integer_List = Arrays.asList(a_Integer);
//        a_Integer_List.add(5);
        int [] a_int = { 1, 2, 3, 4 };
        /*预期输出应该是在1，2，3，4，但实际上输出的仅仅是一个引用,这里它把a_int 当成一个元素*/
        List a_int_List = Arrays.asList(a_int);
        foreach(a_int_List);
        /*为此我们需要这样遍历其中元素*/
        foreachForBase(a_int_List);
    }
    /*打印方法*/
    private static void foreach(List list) {
        for (Object object : list) {
            System.out.println(object + " ");
        }
        System.out.println();
    }
    private static void foreachForBase(List a_int_List) {
        int[] _a_int = (int[]) a_int_List.get(0);
        foreach(_a_int);
    }
    private static void foreach(int[] a_int) {
        for (int i : a_int) {
            System.out.println(i + " ");
        }
        System.out.println();
    }
}
