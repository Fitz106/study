package com.jyp.studydemo.designpatterns.strategy;

import com.jyp.studydemo.designpatterns.strategy.payment.AbstractParamStrategySovler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/25 15:34
 * @description ：整合版策略模式上下文
 */
@Component
public class StrategySolverContext implements ApplicationContextAware {

    private Map<Class, Map<String,StrategySolver>> strategyContextByEnum = new HashMap<>();
    private Map<String,Map<String,StrategySolver>> strategyContextByParamName = new HashMap<>();

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        this.registerByEnum();
        this.registerByParam();
    }


    /**
     * 通过技术支持获取技术支持具体的对象
     *
     * @param enumObj 技术支持
     * @return 技术支持Bean
     */
    public void chooseByEnum(Enum enumObj,Object obj) {
        String name = obj.getClass().getName();
        Map<String,StrategySolver> map = strategyContextByEnum.get(name);
        if (map != null){
            StrategySolver strategySolver = map.get(enumObj.name());
            if (strategySolver != null){
                strategySolver.solve(obj);
            }
        }
    }

    /**
     * 通过技术支持获取技术支持具体的对象
     *
     * @param enumObj 技术支持
     * @return 技术支持Bean
     */
    public void chooseByParam(Enum enumObj,Object obj) {
        String name = obj.getClass().getName();
        Map<String,StrategySolver> map = strategyContextByParamName.get(name);
        if (map != null){
            StrategySolver strategySolver = map.get(enumObj.name());
            if (strategySolver != null){
                strategySolver.solve(obj);
            }
        }
    }

    /**
     * 从spring容器中获取所有的跟技术支持相关的Bean
     * key为技术支持类型，value为bean存储到技术支持容器中
     */
    private void registerByEnum() {
        Map<String, StrategySolver> solverMap = applicationContext.getBeansOfType(StrategySolver.class);
        for (StrategySolver solver : solverMap.values()) {
            Enum[] enums = solver.supports();
            for (Enum enumEntity : enums){
                Class enumClass = enumEntity.getClass();
                Map<String,StrategySolver> strategySolverMap = null;
                if (strategyContextByEnum.containsKey(enumClass)){
                    strategySolverMap = strategyContextByEnum.get(enumClass);
                } else {
                    strategySolverMap = new HashMap<>();
                    strategyContextByEnum.put(enumClass,strategySolverMap);
                }
                strategySolverMap.put(enumEntity.name(),solver);
            }
        }
    }

    /**
     * 将实现AbstractParamStrategySovler的策略模式
     * 从spring容器中获取所有的跟技术支持相关的Bean
     * key为技术支持类型，value为bean存储到技术支持容器中
     */
    private void registerByParam() {
        Map<String, AbstractParamStrategySovler> solverMap = applicationContext.getBeansOfType(AbstractParamStrategySovler.class);
        for (AbstractParamStrategySovler solver : solverMap.values()) {
            Enum[] enums = solver.supports();
            String handleType = solver.getHandleType();
            if (handleType != null){
                handleType = handleType.split("<")[0];
            }
            for (Enum enumEntity : enums){
                Map<String,StrategySolver> strategySolverMap = null;
                if (strategyContextByParamName.containsKey(handleType)){
                    strategySolverMap = strategyContextByParamName.get(handleType);
                } else {
                    strategySolverMap = new HashMap<>();
                    strategyContextByParamName.put(handleType,strategySolverMap);
                }
                strategySolverMap.put(enumEntity.name(),solver);
            }
        }
    }
}

