package com.icho.springsource.importTest;

import com.icho.springsource.importTest.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/14 19:57
 * @Describe:
 */
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println("s = " + s);
        }
    }
}
