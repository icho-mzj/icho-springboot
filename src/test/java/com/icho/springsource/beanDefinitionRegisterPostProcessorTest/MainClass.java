package com.icho.springsource.beanDefinitionRegisterPostProcessorTest;

import com.icho.springsource.beanDefinitionRegisterPostProcessorTest.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/15 19:47
 * @Describe:
 */
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        //System.out.println(context.getBean(LogTest.class));
    }
}
