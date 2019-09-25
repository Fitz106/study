package com.jyp.studydemo.designpatterns.strategy.Enums;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/25 14:40
 * @description：枚举接口类
 * getEnums是接口的默认方法，枚举需实现BaseEnum接口，但不需要使用getEnumByDesc、getCodeByName、getDescByCode方法时无需重写getEnums方法
 * 若需要使用，则需要重写getEnums方法，获取Enums对象。
 * Enums对象是getEnumByDesc、getCodeByName、getDescByCode方法的持有者。所有枚举扩展方法都在Enums里维护和提供。
 * 实现getEnums方法示例：
 *    @Override
 *     public Enums getEnums() {
 *         if (enums == null){
 *             this.enums = new Enums(PayTypeEnum.values());
 *         }
 *         return enums;
 *     }
 */
public interface BaseEnum {

    /**
     * code code code
     *
     * @return code
     */
    int getCode();

    /**
     * name
     * @return
     */
    String getName();

    /**
     * desc desc desc
     *
     * @return desc
     */
    String getDesc();

    default Enums getEnums(){
        return null;
    }

}

