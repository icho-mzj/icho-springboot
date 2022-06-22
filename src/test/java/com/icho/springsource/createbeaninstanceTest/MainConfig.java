package com.icho.springsource.createbeaninstanceTest;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @Author: icho
 * @Date: 2022/6/19 21:35
 * @Describe:
 */
public class MainConfig {

    //@Bean(autowire = Autowire.BY_NAME)
    @Bean(autowire = Autowire.BY_TYPE)
    public AspectTest aspectTest() {
        return new AspectTest();
    }

    @Bean
    public LogTest logTest() {
        return new LogTest();
    }

    @Bean
    @Primary
    public LogTest logTest1() {
        return new LogTest();
    }
}
