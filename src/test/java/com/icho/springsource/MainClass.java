package com.icho.springsource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/14 18:31
 * @Describe:
 */
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        //System.out.println(context.getBean("person2"));
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            System.out.println("bean的定义信息: " + s);
        }
    }
}
