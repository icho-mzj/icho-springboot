package com.icho.springsource.componentScanTest.conditionTest;

import com.icho.springsource.componentScanTest.conditionTest.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/14 19:40
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
