package com.icho.springsource.applicationlistenerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: icho
 * @Date: 2022/6/15 19:13
 * @Describe:
 */
@Configuration
public class MainConfig {
    @Bean
    public ApplicationListenerTest applicationListenerTest() {
        return new ApplicationListenerTest();
    }
}
