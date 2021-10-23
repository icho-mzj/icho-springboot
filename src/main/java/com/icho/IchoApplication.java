package com.icho;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: icho
 * @Date: 2021/9/16 15:54
 */
@SpringBootApplication
@MapperScan("com.icho.mapper")
public class IchoApplication {
    public static void main(String[] args) {
        SpringApplication.run(IchoApplication.class, args);
    }
}
