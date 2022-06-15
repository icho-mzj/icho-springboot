package com.icho.springsource.factoryBeanTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:19
 * @Describe:
 */
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Object o = context.getBean("carFactoryBean");
        Object o1 = context.getBean("&carFactoryBean");
        System.out.println("o = " + o);
        System.out.println("o1 = " + o1);
        /*for (String s : context.getBeanDefinitionNames()) {
            System.out.println("s = " + s);
        }*/
    }
}
