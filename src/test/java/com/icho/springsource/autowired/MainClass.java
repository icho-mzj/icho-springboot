package com.icho.springsource.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: icho
 * @Date: 2022/6/15 9:58
 * @Describe:
 */
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        ServiceTest serviceTest = context.getBean(ServiceTest.class);
        System.out.println(serviceTest.toString());

        Object daoTest2 = context.getBean("daoTest2");
        System.out.println(daoTest2.toString());

        BaiDuServiceTest baiDuServiceTest = context.getBean(BaiDuServiceTest.class);
        System.out.println(baiDuServiceTest);
    }
}
