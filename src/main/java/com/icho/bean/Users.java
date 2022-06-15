package com.icho.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: icho
 * @Date: 2022/4/12 23:15
 * @Describe: SpringSecurity
 */
@Data
public class Users implements Serializable,Cloneable {
    private Integer id;
    private String username;
    private String password;

    public Users(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public Users clone() throws CloneNotSupportedException {
        return (Users)super.clone();
    }
}
