package com.icho.springsource.beanlifecycleTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:33
 * @Describe:
 */
@Configuration
@ComponentScan(basePackages = {"com.icho.springsource.beanlifecycleTest"})
public class MainConfig {

    @Scope(value = "prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

    @Bean(initMethod = "init")
    public Log log() {
        return new Log();
    }

    @Bean
    public BeanPostProcessorTest BeanPostProcessor() {
        return new BeanPostProcessorTest();
    }

}
