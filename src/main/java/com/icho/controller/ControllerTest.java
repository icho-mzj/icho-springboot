package com.icho.controller;

import com.icho.bean.User;
import com.icho.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

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

    @RequestMapping("/addUsers")
    public void addUsers(@RequestBody List<User> users) {
        userService.addUsers(users);
    }

    @GetMapping("/queryUsers")
    public List<User> queryUsers() {
        return userService.queryUsers();
    }

    public void methodTest() {
        String s1="a"+"b"+"c";
        String s2="abc";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));



        String a1="ab";
        String a2="abc";
        String a3=a1+"c";
        System.out.println(a3==a2);         // false
        System.out.println(a3.equals(s2));  // true
    }

    // try with
    private static void test01() {
        try (Scanner scanner = new Scanner(new File("testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        }catch (Exception e) {
            System.out.println("Exception in finally block =>"+e.getMessage());
        }
    }

    private static void test02() {
        try {
            Scanner scanner = new Scanner(new File("testRead.txt"));
            PrintWriter writer = new PrintWriter(new File("testWrite.txt"));
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Exception in finally block =>" + e.getMessage());
        }
    }

}

// extends test
class SuperClass {
    private int n;
    SuperClass(){
        System.out.println("SuperClass()");
    }
    SuperClass(int n) {
        System.out.println("SuperClass(int n)");
        this.n = n;
    }
}
// SubClass 类继承
class SubClass extends SuperClass{
    private int n;

    SubClass(){ // 自动调用父类的无参数构造器
        System.out.println("SubClass");
    }

    public SubClass(int n){
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass(int n):"+n);
        this.n = n;
    }
}
// SubClass2 类继承
class SubClass2 extends SuperClass {
    private int n;

    SubClass2() {
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass2");
    }

    public SubClass2(int n) { // 自动调用父类的无参数构造器
        System.out.println("SubClass2(int n):" + n);
        this.n = n;
    }
}

// SubClass3 类继承
class SubClass3 {
    private int n;
}

interface InterfaceTest {
    String s = "test";
    void test();
}
