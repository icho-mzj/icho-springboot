package com.icho.springsource.beanDefinitionRegisterPostProcessorTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Author: icho
 * @Date: 2022/6/15 19:47
 * @Describe:
 */
@Component
public class BeanDefinitionRegisterPostProcessorTest implements BeanDefinitionRegistryPostProcessor { // bean定义还没被扫描/加载之前可以往容器中自己添加
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor的postProcessBeanDefinitionRegistry方法");
        System.out.println("bean定义的数据量" + registry.getBeanDefinitionCount());
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        registry.registerBeanDefinition("logTest", rootBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanDefinitionRegisterPostProcessorTest的postProcessBeanFactory方法");
        System.out.println(beanFactory.getBeanDefinitionCount());
    }
}
