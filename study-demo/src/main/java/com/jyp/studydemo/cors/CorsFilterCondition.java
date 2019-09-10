package com.jyp.studydemo.cors;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2019/9/7 18:40
 * @description：跨域开关设置
 */
public class CorsFilterCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        final String condition = conditionContext.getEnvironment().getProperty("config.cors-filter-switch");
        boolean condit = "true".equalsIgnoreCase(condition);
        return condit;
    }
}
