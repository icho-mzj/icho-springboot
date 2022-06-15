package com.icho.springsource.importTest.config;

import com.icho.springsource.importTest.importSelectTest.BeanDefinitionRegisterTest;
import com.icho.springsource.importTest.importSelectTest.ImportSelectTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: icho
 * @Date: 2022/6/14 19:57
 * @Describe:
 */
@Configuration
//@Import(value = {Person.class, Car.class})
@Import(value = {ImportSelectTest.class, BeanDefinitionRegisterTest.class})
public class MainConfig {
}
