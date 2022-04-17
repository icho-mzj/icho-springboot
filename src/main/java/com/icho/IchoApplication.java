package com.icho;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

import static org.apache.commons.lang3.time.DateUtils.parseDate;

/**
 * @Author: icho
 * @Date: 2021/9/16 15:54
 */
@SpringBootApplication
@EnableScheduling
@EnableGlobalMethodSecurity(
        securedEnabled = true, // 校验角色,有才能访问接口
        prePostEnabled = true // 进入方法前的权限验证,可以将登录用 户的 roles/permissions 参数传到方法中
)
public class IchoApplication {
    public static void main(String[] args) {
        SpringApplication.run(IchoApplication.class, args);
    }
}


