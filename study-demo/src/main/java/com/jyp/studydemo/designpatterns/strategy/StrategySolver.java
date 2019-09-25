package com.jyp.studydemo.designpatterns.strategy;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/14 21:22
 * @description：处理器
 */
public interface StrategySolver<T> {
    /**
     * 具体的处理逻辑
     * @param t t
     */
    void solve(T t);

    /**
     * 该类可以提供的技术支持
     *
     * @return 技术支持[]
     */
    Enum[] supports();
}

