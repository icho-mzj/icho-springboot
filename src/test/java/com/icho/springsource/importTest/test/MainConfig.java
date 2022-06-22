package com.icho.springsource.importTest.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: icho
 * @Date: 2022/6/15 14:38
 * @Describe:
 */
@Configuration
//@Import(value = {Person.class})
@Import(value = {ImportSelectorTest.class,BeanDefinitionRegistryTest.class})
public class MainConfig {
}
