package com.icho.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icho.bean.User;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author: icho
 * @Date: 2022/5/11 19:24
 * @Describe:
 */
public class JsonTest {

    public static void main(String[] args) {
        test02();
    }

    // JackSon
    private static void test02() {
        User1 user = new User1();
        user.setUserName("icho");
        user.setPassword("123");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(user);
            System.out.println("s = " + s);

            User1 user1 = objectMapper.readValue(s, User1.class);
            System.out.println("user1 = " + user1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // FastJson
    private static void test01() {
        User1 user = new User1();
        user.setUserName("icho");
        user.setPassword("123");
        System.out.println(user.toString());

        String s = JSONObject.toJSONString(user);
        System.out.println("s = " + s);

        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println("jsonObject = " + jsonObject);
    }
}

class User1 {
    public String userName;
    public String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User1{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
