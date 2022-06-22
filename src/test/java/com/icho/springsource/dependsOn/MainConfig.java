package com.icho.springsource.dependsOn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

/**
 * @Author: icho
 * @Date: 2022/6/18 15:26
 * @Describe:
 */
public class MainConfig {

    @Bean
    //@DependsOn(value = "dependsB")
    public DependsA dependsA() {
        return new DependsA();
    }

    @Bean
    @DependsOn(value = "dependsA")
    public DependsB dependsB() {
        return new DependsB();
    }
}
