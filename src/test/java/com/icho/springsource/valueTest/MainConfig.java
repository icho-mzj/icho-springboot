package com.icho.springsource.valueTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: icho
 * @Date: 2022/6/14 21:17
 * @Describe:
 */
@Configuration
@PropertySource(value = {"classpath:person.properties"})
public class MainConfig {

    @Bean
    public Person person() {
        return new Person();
    }
}
