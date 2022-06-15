package com.icho.springsource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: icho
 * @Date: 2022/6/14 18:31
 * @Describe:
 */
@Configuration
public class MainConfig {

    @Bean(value = "person2")
    public Person person() {
        return new Person();
    }
}
