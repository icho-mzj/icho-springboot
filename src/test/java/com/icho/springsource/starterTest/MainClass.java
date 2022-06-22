package com.icho.springsource.starterTest;

import com.icho.springsource.autowired.DaoTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/16 17:43
 * @Describe:
 */
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        System.out.println(context.getBean("controllerTest",ControllerTest.class));

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        System.out.println(context.getBeanDefinitionNames().length);

    }
}
