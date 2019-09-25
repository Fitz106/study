package com.jyp.studydemo.designpatterns.strategy.payment;

import com.jyp.studydemo.designpatterns.strategy.StrategySolver;

import java.lang.reflect.ParameterizedType;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/24 16:46
 * @description：策略模式的业务参数类型抽象类
 *  主要提供一种可以通过业务处理时通过一个枚举类做两种策略模式的实现
 */
public abstract class AbstractParamStrategySovler<T> implements StrategySolver<T>{

    /**
     * 该类可以提供的技术支持
     *
     * @return 技术支持[]
     */
    public String getHandleType() {
        // 获取当前new的对象的泛型的父类类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取第一个类型参数的真实类型
        return  pt.getActualTypeArguments()[0].getTypeName();

    }
}
