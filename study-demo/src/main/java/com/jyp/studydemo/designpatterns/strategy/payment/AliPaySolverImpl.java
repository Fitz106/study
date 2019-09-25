package com.jyp.studydemo.designpatterns.strategy.payment;


import com.jyp.studydemo.designpatterns.strategy.StrategySolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/24 16:46
 * @description： alipay业务处理器
 */
@Slf4j
@Component
public class AliPaySolverImpl extends AbstractParamStrategySovler<PaySolveParam<String>> {


    @Override
    public void solve(PaySolveParam<String> paySolveParam) {
        paySolveParam.setSolveResult("支付宝支付 10元");
    }



    @Override
    public Enum[] supports() {
        return new Enum[]{PayTypeEnum.ALIPAY};
    }


}
