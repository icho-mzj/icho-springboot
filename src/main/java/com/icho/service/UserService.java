package com.icho.service;

import com.icho.bean.User;
import com.icho.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: icho
 * @Date: 2021/9/16 20:11
 * @Describe:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        // 开始查询
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public Integer saveUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Transactional
    public void deleteById(Long id) {
        System.out.println("删除了 : " + id);
    }
}
