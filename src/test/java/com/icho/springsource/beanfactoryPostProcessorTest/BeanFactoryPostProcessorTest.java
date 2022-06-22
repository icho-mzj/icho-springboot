package com.icho.springsource.beanfactoryPostProcessorTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: icho
 * @Date: 2022/6/15 19:34
 * @Describe:
 */
@Component
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor { // 在bean解析后实例化之前操作bean
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("IOC容器调用了BeanFactoryPostProcessor的postProcessBeanFactory");
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            if ("logTest".equals(beanDefinitionName)) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
                beanDefinition.setLazyInit(true);
            }
        }
    }
}
