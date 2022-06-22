package com.icho.springsource.importTest.test;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: icho
 * @Date: 2022/6/15 15:07
 * @Describe:
 */
public class BeanDefinitionRegistryTest implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 构造bean定义
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Animal.class);
        registry.registerBeanDefinition("animal",rootBeanDefinition);
    }
}
