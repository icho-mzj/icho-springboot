package com.icho.springsource.valueTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/14 21:17
 * @Describe:
 */
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = context.getBean(Person.class);
        System.out.println("bean = " + bean);
    }
}
