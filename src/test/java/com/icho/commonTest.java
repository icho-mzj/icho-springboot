package com.icho;

import com.icho.bean.BaseEntity;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: icho
 * @Date: 2021/12/25 21:35
 * @Describe:
 */
public class commonTest {

    @Test
    public void test01() {
        System.out.println(BaseEntity.Fields.createDate);
    }

    @Test
    public void test02() {
        List<String> list = Arrays.asList("1", "2", "3");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
    }

}
