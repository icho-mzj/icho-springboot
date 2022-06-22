package com.icho.springsource.profilesTest.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: icho
 * @Date: 2022/6/15 17:04
 * @Describe:
 */
@PropertySource(value = "classpath:person.properties")
public class MainConfig {

    @Value("${person.lastName}")
    private String name;

    @Bean
    public String getName() {
        System.out.println("name = " + name);
        return name;
    }
}
