package com.icho.springsource.scopeTest.config;

import com.icho.springsource.scopeTest.compent.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @Author: icho
 * @Date: 2022/6/14 19:17
 * @Describe:
 */
public class MainConfig {

    @Bean(value = "person")
    @Lazy // 懒加载
    //@Scope(scopeName = "prototype")
    public Person person() {
        return new Person();
    }
}
