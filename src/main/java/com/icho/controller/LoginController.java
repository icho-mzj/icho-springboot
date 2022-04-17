package com.icho.controller;

import com.icho.bean.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: icho
 * @Date: 2022/4/13 22:28
 * @Describe:
 */
@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String login() {
        return "login";
    }

    @RequestMapping("/fail")
    public String fail() {
        return "fail";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll() {
        return "findAll";
    }

    @RequestMapping("/noPage")
    public String noPage() {
        return "404";
    }


    /* @Secured */
    /* 判断是否具有角色,进入方法前校验 */
    @GetMapping("/testSecured")
    @Secured({"管理员", "普通用户"}) //校验权限的注解
    public String testSecured() {
        return "hello,Secured";
    }

    @GetMapping("/testSecured1")
    @Secured({"普通用户"}) //校验权限的注解
    public String testSecured1() {
        return "hello,Secured1";
    }

    @GetMapping("/testSecured2")
    @Secured({"管理员"}) //校验权限的注解
    public String testSecured2() {
        return "hello,Secured2";
    }

    /* @PreAuthorize */
    @GetMapping("/testPreAuthorize")
    @PreAuthorize("hasAnyAuthority('menu:system')")
    @ResponseBody
    public String testPreAuthorize() {
        System.out.println("PreAuthorize");
        return "hello PreAuthorize";
    }

    @GetMapping("/testPreAuthorize1")
    @PreAuthorize("hasAuthority('普通用户')")
    @ResponseBody
    public String testPreAuthorize1() {
        System.out.println("PreAuthorize1");
        return "hello PreAuthorize1";
    }

    /* @PostAuthorize 方法执行后再进行权限验证 */
    @GetMapping("/testPostAuthorize")
    @PostAuthorize("hasAnyAuthority('menu:system')")
    @ResponseBody
    public String preAuthorize() {
        System.out.println("test--PostAuthorize");
        return "PostAuthorize";
    }

    /* @PostFilter ：权限验证之后对数据进行过滤 留下用户名是 admin1 的数据 */
    @RequestMapping("/getAll")
    @PreAuthorize("hasAuthority('管理员')")
    @PostFilter("filterObject.username == 'admin1'")
    @ResponseBody
    public List<Users> getAllUser() {
        System.out.println("PostFilter");
        List<Users> list = new ArrayList<>();
        list.add(new Users(1, "admin1", "6666"));
        list.add(new Users(2, "admin2", "888"));
        return list;
    }

    /* @PreFilter: 进入控制器之前对数据进行过滤 */
    @RequestMapping("getTestPreFilter")
    @PreAuthorize("hasAuthority('管理员')")
    @PreFilter(value = "filterObject.id%2!=0") // 返回的数据
    @ResponseBody
    public List<Users> getTestPreFilter(@RequestBody List<Users> list){
        list.forEach(t-> {
            System.out.println(t.toString());
        });
        return list;
    }


}
