package com.jyp.studydemo.builder;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/7/23 15:06
 * @description：${description}
 */
public class TwoProuductBuilder implements ProductBuilder{

    private Product product;

    public TwoProuductBuilder(){
        this.product = new Product("twoProduct_param1");
    }
    @Override
    public void setParam1() {
        product.setParam1("twoProduct_param1");
    }

    @Override
    public void setParam2() {
        product.setParam2("twoProduct_param2");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
