package com.icho.service.impl;

import com.icho.bean.User;
import com.icho.cluster.mapper.UserMapperC;
import com.icho.master.mapper.MUserMapper;
import com.icho.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: icho
 * @Date: 2021/11/27 19:45
 * @Describe:
 */
@Log
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MUserMapper MUserMapper;

    @Autowired
    private UserMapperC userMapperC;

    public User queryById(Long id) {
        // 开始查询
        User userM = MUserMapper.selectByPrimaryKey(id);
        System.out.println("userM = " + userM);
        User userC = userMapperC.selectByPrimaryKey(id);
        System.out.println("userC = " + userC);

        return userMapperC.selectByPrimaryKey(id);
    }

    @Transactional
    public Integer saveUser(User user) {
        //int i = userMapperC.insertSelective(user);
        //int j = 1 / 0;
        return null;
    }

    @Transactional
    public void deleteById(Long id) {
        System.out.println("删除了 : " + id);
    }

    @Override
    @Transactional
    public void addUsers(List<User> users) {
        MUserMapper.addUsers(users);
    }

    @Override
    public List<User> queryUsers() {
        return MUserMapper.selectUsers();
    }
}
