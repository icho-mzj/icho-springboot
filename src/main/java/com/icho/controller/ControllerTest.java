package com.icho.controller;

import com.icho.bean.User;
import com.icho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: icho
 * @Date: 2021/9/16 15:55
 */
@RestController
@RequestMapping("/test")
public class ControllerTest {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "hello, spring boot!";
    }

    @RequestMapping("/user/{id}")
    public User queryById(@PathVariable("id") Long id) {
        User user = userService.queryById(id);
        return user;
    }
}
