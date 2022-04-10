package com.icho;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
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
public class IchoApplication {
    public static void main(String[] args) {
        SpringApplication.run(IchoApplication.class, args);
    }
}


