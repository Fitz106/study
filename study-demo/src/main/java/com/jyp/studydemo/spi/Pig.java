package com.jyp.studydemo.spi;

import javafx.beans.property.SimpleObjectProperty;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/5/6 10:18
 * @description：${description}
 */
public class Pig implements Animal {
    @Override
    public void eat() {
        System.out.println("Pig eating...");
    }
}
