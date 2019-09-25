package com.jyp.studydemo.service.Impl;

import com.jyp.studydemo.designpatterns.strategy.StrategySolverContext;
import com.jyp.studydemo.designpatterns.strategy.StrategySolverParamContext;
import com.jyp.studydemo.designpatterns.strategy.payment.PaySolveParam;
import com.jyp.studydemo.designpatterns.strategy.payment.PayTypeEnum;
import com.jyp.studydemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/14 22:00
 * @description：${description}
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    StrategySolverContext strategySolverContext;
    @Override
    public String test() {

        return null;
    }

    @Override
    public String testStrategy(String type) {
        PaySolveParam<String> paySolveParam = new PaySolveParam<>();
        paySolveParam.setPayType(PayTypeEnum.BANK_CARD.getDesc());
        strategySolverContext.chooseByParam(PayTypeEnum.BANK_CARD,paySolveParam);
        return null;
    }
}
