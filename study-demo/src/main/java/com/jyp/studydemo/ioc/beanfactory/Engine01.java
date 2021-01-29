//package com.jyp.studydemo.ioc.beanfactory;
//
//import org.springframework.beans.factory.BeanNameAware;
//
///**
// * @author ：jiyuepeng
// * @date ：Created in 2020/11/5 22:06
// * @description：${description}
// */
//public class Engine01 implements Engine, BeanNameAware {
//
//    String name;
//
//    @Override
//    public void fire() {
//        System.out.println("Engine01 fire : " + name +"  : "+ this.toString());
//    }
//
//    @Override
//    public void setBeanName(String name) {
//        System.out.println("Engine01 setting bean name"+name);
//        this.name = name;
//    }
//}
