package com.icho.service;

import com.icho.bean.User;

import java.util.List;

/**
 * @Author: icho
 * @Date: 2021/9/16 20:11
 * @Describe:
 */
public interface UserService {

    public User queryById(Long id);

    public Integer saveUser(User user);

    public void deleteById(Long id);

    void addUsers(List<User> users);

    List<User> queryUsers();
}
