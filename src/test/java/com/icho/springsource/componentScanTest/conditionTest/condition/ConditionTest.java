package com.icho.springsource.componentScanTest.conditionTest.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: icho
 * @Date: 2022/6/14 19:40
 * @Describe:
 */
public class ConditionTest implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 判断容器中是否有AspectTest组件
        if (context.getBeanFactory().containsBean("AspectTest")) {
            return true;
        }
        return false;
    }
}
