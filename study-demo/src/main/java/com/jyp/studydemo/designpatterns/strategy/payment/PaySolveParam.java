package com.jyp.studydemo.designpatterns.strategy.payment;

import lombok.Data;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/17 10:46
 * @description：支付业务参数对象
 */
@Data
public class PaySolveParam<T> {
    private String payType;
    private T solveResult;
}
