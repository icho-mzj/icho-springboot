package com.icho.springsource.valueTest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: icho
 * @Date: 2022/6/14 21:14
 * @Describe:
 */
@Data
public class Person {
    @Value("icho")
    private String name;
    @Value("#{26-8}")
    private int age;
    @Value("${person.lastName}")
    private String lastName;
}
