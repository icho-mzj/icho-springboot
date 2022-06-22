package com.icho.springsource.starterTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Author: icho
 * @Date: 2022/6/16 17:44
 * @Describe:
 */
@Import(value = Person.class)
@ComponentScan(value = "com.icho.springsource.starterTest")
public class MainConfig {
    @Bean
    public Animal animal() {
        return new Animal();
    }
}
