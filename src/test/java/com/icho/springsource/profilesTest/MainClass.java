package com.icho.springsource.profilesTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/15 10:18
 * @Describe:
 */
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 容器获得环境设置激活的环境
        //context.getEnvironment().setActiveProfiles("test"); // 可修改VM参数配置启动环境 -Dspring.profiles.active=xx
        context.register(MainConfig.class);
        context.refresh();

        printBeanName(context);
    }

    private static void printBeanName(AnnotationConfigApplicationContext context) {
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }
}
