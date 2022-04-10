package com.icho.controller;

import com.icho.bean.User;
import com.icho.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String hello(@RequestParam String date) {
        return "hello, spring boot!";
    }

    @GetMapping("/test01")
    public String test01(@RequestBody @Valid User user) {
        return "pass the check";
    }

    @ApiOperation(value = "查询用户")
    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = User.class)})
    @RequestMapping("/user/{id}")
    public User queryById(@PathVariable("id") Long id) {
        User user = userService.queryById(id);
        return user;
    }

}
