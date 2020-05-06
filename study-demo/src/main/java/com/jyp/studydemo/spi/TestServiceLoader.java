package com.jyp.studydemo.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/5/6 23:11
 * @description：${description}
 */
public class TestServiceLoader {

    public static void main(String[] args){
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
        Iterator<Animal> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            Animal animal = iterator.next();
            animal.eat();
        }
    }
}
