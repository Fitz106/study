package com.jyp.studydemo.designpatterns.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/25 15:24
 * @description：根据枚举类来隔离每种枚举的不同业务处理器
 */
@Component
public class StrategySolverEnumContext  implements ApplicationContextAware {

    private Map<Class, Map<String,StrategySolver>> strategyContext = new HashMap<>();

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        this.register();
    }


    /**
     * 通过技术支持获取技术支持具体的对象
     *
     * @param enumObj 技术支持
     * @return 技术支持Bean
     */
    public void choose(Enum enumObj,Object obj) {
        String name = obj.getClass().getName();
        Map<String,StrategySolver> map = strategyContext.get(name);
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
    private void register() {
        Map<String, StrategySolver> solverMap = applicationContext.getBeansOfType(StrategySolver.class);
        for (StrategySolver solver : solverMap.values()) {
            Enum[] enums = solver.supports();
            for (Enum enumEntity : enums){
                Class enumClass = enumEntity.getClass();
                Map<String,StrategySolver> strategySolverMap = null;
                if (strategyContext.containsKey(enumClass)){
                    strategySolverMap = strategyContext.get(enumClass);
                } else {
                    strategySolverMap = new HashMap<>();
                    strategyContext.put(enumClass,strategySolverMap);
                }
                strategySolverMap.put(enumEntity.name(),solver);
            }
        }
    }

}

