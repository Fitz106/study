package com.jyp.studydemo.builder;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/7/23 15:06
 * @description：${description}
 */
public class OneProuductBuilder implements ProductBuilder{

    private Product product;

    public OneProuductBuilder(){
        this.product = new Product("oneProduct_Param1");
    }
    @Override
    public void setParam1() {
        product.setParam1("oneProduct_Param1");
    }

    @Override
    public void setParam2() {
        product.setParam2("oneProduct_Param2");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
