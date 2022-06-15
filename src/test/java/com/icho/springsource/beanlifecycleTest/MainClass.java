package com.icho.springsource.beanlifecycleTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:32
 * @Describe:
 */
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        //Car car = context.getBean(Car.class);
        context.close();
    }
}
