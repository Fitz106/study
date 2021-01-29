package com.jyp.studydemo.builder;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/7/23 15:15
 * @description：${description}
 */
public class Director {
    private ProductBuilder productBuilder;
    public void setProductBuilder(ProductBuilder productBuilder){
        this.productBuilder = productBuilder;
    }
    public void createProduct(){
        productBuilder.setParam1();
        productBuilder.setParam2();
    }
    public Product getProduct(){
        return productBuilder.getProduct();
    }
}
