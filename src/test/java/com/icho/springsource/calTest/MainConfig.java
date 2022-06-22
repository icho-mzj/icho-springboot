package com.icho.springsource.calTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: icho
 * @Date: 2022/6/20 19:50
 * @Describe:
 */
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.icho.springsource.calTest"})
public class MainConfig {

    /*@Bean
    public CalculateTest calculateTest() {
        return new CalculateTest();
    }

    @Bean
    public LogAspectTest logAspectTest() {
        return new LogAspectTest();
    }*/

}
