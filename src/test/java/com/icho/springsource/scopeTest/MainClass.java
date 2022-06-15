package com.icho.springsource.scopeTest;

import com.icho.springsource.scopeTest.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/14 19:18
 * @Describe:
 */
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        /*Person person1 = (Person) context.getBean("person");
        Person person2 = (Person) context.getBean("person");
        System.out.println(person1 == person2);*/
    }
}
