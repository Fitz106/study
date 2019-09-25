package com.jyp.studydemo.designpatterns.strategy.preferential;

import lombok.Data;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/17 10:46
 * @description：优惠方案业务参数对象
 */
@Data
public class PreferentialSolveParam<T> {
    private String payType;
    private T solveResult;
}
