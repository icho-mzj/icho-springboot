package com.icho.springsource.calTest;

import com.icho.springsource.calTest.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/20 19:31
 * @Describe:
 */
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Calculate calculate = (Calculate) context.getBean("calculateTest");
        int result = calculate.add(2, 4);
        System.out.println("result = " + result);
    }
}
