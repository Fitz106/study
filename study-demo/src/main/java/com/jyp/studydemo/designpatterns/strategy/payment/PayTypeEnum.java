package com.jyp.studydemo.designpatterns.strategy.payment;

import com.jyp.studydemo.designpatterns.strategy.Enums.BaseEnum;
import com.jyp.studydemo.designpatterns.strategy.Enums.Enums;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/25 14:49
 * @description：支付类型枚举对象
 */
public enum PayTypeEnum implements BaseEnum {
    /**
     * 银行卡支付
     */
    BANK_CARD(1,"bankCard",null),
    /**
     * 支付宝
     */
    ALIPAY(2,"aliPay",null),
    /**
     * 微信
     */
    WECHAT_PAYMENT(3,"weChatPayment",null)
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

    private Enums enums;

    PayTypeEnum(int code, String name,String desc) {
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

    @Override
    public Enums getEnums() {
        if (enums == null){
            this.enums = new Enums(PayTypeEnum.values());
        }
        return enums;
    }


}

