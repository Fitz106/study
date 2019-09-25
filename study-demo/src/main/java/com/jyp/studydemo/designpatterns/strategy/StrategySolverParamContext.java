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
 * @date ：Created in 2019/9/14 21:34
 * @description：根据业务参数类型不同来隔离每种枚举的不同业务处理器
 */
@Component
public class StrategySolverParamContext implements ApplicationContextAware {

    private Map<String,Map<String,StrategySolver>> strategyContext = new HashMap<>();

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
        Map<String, AbstractParamStrategySovler> solverMap = applicationContext.getBeansOfType(AbstractParamStrategySovler.class);
        for (AbstractParamStrategySovler solver : solverMap.values()) {
            Enum[] enums = solver.supports();
            String handleType = solver.getHandleType();
            if (handleType != null){
                handleType = handleType.split("<")[0];
            }
            for (Enum enumEntity : enums){
                Map<String,StrategySolver> strategySolverMap = null;
                if (strategyContext.containsKey(handleType)){
                    strategySolverMap = strategyContext.get(handleType);
                } else {
                    strategySolverMap = new HashMap<>();
                    strategyContext.put(handleType,strategySolverMap);
                }
                strategySolverMap.put(enumEntity.name(),solver);
            }
        }
    }

}
