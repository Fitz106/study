package com.jyp.studydemo.builder;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/7/23 15:17
 * @description：${description}
 */
public class Client {

    public static void main(String[] args){
        Director director = new Director();
        director.setProductBuilder(new OneProuductBuilder());
        director.createProduct();
        Product product = director.getProduct();
    }

}
