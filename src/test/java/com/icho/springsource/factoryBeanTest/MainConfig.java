package com.icho.springsource.factoryBeanTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:20
 * @Describe:
 */
@Configuration
public class MainConfig {
    @Bean
    public CarFactoryBean carFactoryBean() {
        return new CarFactoryBean();
    }
}
