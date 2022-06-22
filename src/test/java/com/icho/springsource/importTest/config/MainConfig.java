package com.icho.springsource.importTest.config;

import com.icho.springsource.Person;
import com.icho.springsource.importTest.compent.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @Author: icho
 * @Date: 2022/6/14 19:57
 * @Describe:
 */
//@Configuration
@Import(value = {Person.class, Car.class})
//@Import(value = {ImportSelectTest.class, BeanDefinitionRegisterTest.class})
public class MainConfig {
    @Bean
    public Person person() {
        return new Person();
    }
}
