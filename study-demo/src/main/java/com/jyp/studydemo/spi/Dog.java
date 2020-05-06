package com.jyp.studydemo.spi;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/5/6 10:20
 * @description：${description}
 */
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog eating...");
    }
}
