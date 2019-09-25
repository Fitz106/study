package com.jyp.studydemo.validator;

import com.baidu.unbiz.fluentvalidator.*;
import com.baidu.unbiz.fluentvalidator.validator.element.ValidatorElementList;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/11 18:48
 * @description：${description}
 */
@Slf4j
public class ValidatorTest {

    public static void main(String[] args){
        Car car = new Car();
        car.setLicensePlate("mmmmmmmmm");
        car.setManufacturer("xxxxxxxxxx");
        car.setSeatCount(6);

        Result ret = FluentValidator.checkAll().on(car.getLicensePlate(),new CarLicensePlateValidator())
                .on(car.getManufacturer(),new CarManufacturerValidator())
                .on(car.getSeatCount(), new CarSeatCountValidator())
                .doValidate()
                .result(toSimple());

        System.out.println(ret);


        ValidatorChain chain = new ValidatorChain();
        List<Validator> validators = new ArrayList<Validator>();
        validators.add(new CarManufacturerValidator());
        validators.add(new CarLicensePlateValidator());

        validators.add(new CarSeatCountValidator());
        chain.setValidators(validators);

        Result ret2 = FluentValidator.checkAll().on(car, chain).doValidate().result(toSimple());
        System.out.println(ret2);


        Result ret3 = FluentValidator.checkAll()
                .on(car.getSeatCount(), new CarSeatCountValidator())
                .doValidate(new DefaultValidateCallback() {

                    @Override
                    public void onSuccess(ValidatorElementList validatorElementList) {
                        log.info("all ok!");
                    }
                }).result(toSimple());
        System.out.println(ret3);

    }
}
