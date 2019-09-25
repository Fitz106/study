package com.jyp.studydemo.designpatterns.strategy.preferential;


import com.jyp.studydemo.designpatterns.strategy.Enums.BaseEnum;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/25 14:49
 * @description：优惠方案类型枚举对象
 */
public enum PreferentialTypeEnum implements BaseEnum {
    /**
     * 优惠方案1
     */
    PREFERENTIAL_1(1,"preferential_1",null),
    /**
     * 优惠方案2
     */
    PREFERENTIAL_2(2,"preferential_2",null)
    ;
    /**
     * 状态码
     */
    private int code;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String desc;

    PreferentialTypeEnum(int code, String name,String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDesc() {
        return desc;
    }


}
