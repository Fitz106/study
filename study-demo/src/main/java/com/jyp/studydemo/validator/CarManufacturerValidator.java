package com.jyp.studydemo.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/11 18:51
 * @description：${description}
 */
public class CarManufacturerValidator extends ValidatorHandler<String> implements Validator<String> {
    @Override
    public boolean validate(ValidatorContext context, String t) {
        if (t.contains("y")) {
            context.addErrorMsg(String.format("Seat count is not valid, invalid value=%s", t));
            return false;
        }
        return true;
    }

    @Override
    public void onException(Exception e, ValidatorContext context, String s) {
        super.onException(e, context, s);
    }
}
