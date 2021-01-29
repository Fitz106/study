package com.jyp.studydemo.builder;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/7/23 14:59
 * @description：${description}
 */
public class Product {
    private String param1;
    private String param2;
    private String param3;
    private String param4;

    public Product(String param1){
        this(param1,"param2");
    }
    public Product(String param1,String param2){
        this(param1,param2,"param3");
    }
    public Product(String param1,String param2,String param3){
        this(param1,param2,param3,"param4");
    }
    public Product(String param1,String param2,String param3,String param4){
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
    }


    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }


    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }
}
