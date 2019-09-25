package com.jyp.studydemo.designpatterns.strategy.preferential;


import com.jyp.studydemo.designpatterns.strategy.payment.AbstractParamStrategySovler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/24 16:46
 * @description： 优惠方案2的业务处理器
 */
@Slf4j
@Component
public class Preferential2SolverImpl extends AbstractParamStrategySovler<PreferentialSolveParam<String>> {


    @Override
    public void solve(PreferentialSolveParam<String> preferentialSolveParam) {
        preferentialSolveParam.setSolveResult("优惠方案2：优惠2元");
    }

    @Override
    public Enum[] supports() {
        return new Enum[]{PreferentialTypeEnum.PREFERENTIAL_2};
    }


}
