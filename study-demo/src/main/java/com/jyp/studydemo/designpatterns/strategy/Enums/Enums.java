package com.jyp.studydemo.designpatterns.strategy.Enums;

import java.util.Objects;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/25 14:25
 * @description：枚举数组对象
 *  getEnumByDesc、getCodeByName、getDescByCode方法的持有者，后续有关枚举的扩展方法都在这里维护
 */
public class Enums {

    private final BaseEnum[] baseEnums;
    public Enums(BaseEnum[] array) {
        baseEnums = Objects.requireNonNull(array);
    }
    public BaseEnum getEnumByDesc(String desc){
        if(desc==null||desc.length()==0){
            throw new IllegalArgumentException("desc can not be null in MyArrays.Enums.getCodeByDesc");
        }
        for(BaseEnum baseEnum:baseEnums){
            if(desc.equals(baseEnum.getDesc())){
                return baseEnum;
            }
        }
        return null;
    }



    public int getCodeByDesc(String desc){
        if(desc==null||desc.length()==0){
            throw new IllegalArgumentException("desc can not be null in MyArrays.Enums.getCodeByDesc");
        }
        for(BaseEnum baseEnum:baseEnums){
            if(desc.equals(baseEnum.getDesc())){
                return baseEnum.getCode();
            }
        }
        throw new IllegalArgumentException("The desc{"+desc+"} may be a wrong value ~ please check your param and try again ~");
    }

    public String getDescByCode(int code){
        for (BaseEnum baseEnum:baseEnums){
            if(code==baseEnum.getCode()){
                return baseEnum.getDesc();
            }
        }
        throw new IllegalArgumentException("The code{"+code+"} may be a wrong value ~ please check your param and try again ~");
    }
}



