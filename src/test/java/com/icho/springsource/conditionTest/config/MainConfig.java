package com.icho.springsource.conditionTest.config;

import com.icho.springsource.conditionTest.compent.AspectTest;
import com.icho.springsource.conditionTest.compent.LogTest;
import com.icho.springsource.conditionTest.condition.ConditionTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @Author: icho
 * @Date: 2022/6/14 19:40
 * @Describe:
 */
public class MainConfig {

    //@Bean
    public AspectTest aspectTest() {
        return new AspectTest();
    }

    @Bean
    @Conditional(value = ConditionTest.class)
    public LogTest logTest() {
        return new LogTest();
    }
}
