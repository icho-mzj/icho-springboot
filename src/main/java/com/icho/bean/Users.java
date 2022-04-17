package com.icho.bean;

import lombok.Data;

/**
 * @Author: icho
 * @Date: 2022/4/12 23:15
 * @Describe: SpringSecurity
 */
@Data
public class Users {
    private Integer id;
    private String username;
    private String password;

    public Users(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
