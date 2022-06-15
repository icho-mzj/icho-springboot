package com.icho.springsource.beanlifecycleTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:33
 * @Describe:
 */
//@Component
public class BeanPostProcessorTest implements BeanPostProcessor { // bean后置处理器; 用来修改bean的属性

    // 初始化之前调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization is running: " + beanName);
        return bean;
    }

    // 初始化之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization is running: " + beanName);
        return bean;
    }
}
