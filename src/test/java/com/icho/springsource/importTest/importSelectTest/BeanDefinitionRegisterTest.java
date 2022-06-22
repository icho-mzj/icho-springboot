package com.icho.springsource.importTest.importSelectTest;

import com.icho.springsource.Person;
import com.icho.springsource.importTest.test.Human;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:07
 * @Describe:
 */
public class BeanDefinitionRegisterTest implements ImportBeanDefinitionRegistrar {
    // 通过bean定义注册器注册bean定义信息
    // 保存到BeanDefinitionMap(bean定义注册表)中
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 构造bean定义
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Person.class);
        registry.registerBeanDefinition("person",rootBeanDefinition);
    }
}
