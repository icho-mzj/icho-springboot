package com.icho.util.transaction;

import com.icho.bean.User;
import com.icho.master.mapper.MUserMapper;
import com.icho.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: icho
 * @Date: 2021/9/19 19:27
 * @Describe:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionalDemo {

    @Autowired
    private MUserMapper MUserMapper;

    @Autowired
    private UserServiceImpl userService;

    /*
    * 事务的7种传播行为
    * */

    @Test
    //@Transactional
    public void test01() {
        // transactional();
        User user = new User();
        user.setUserName("icho");
        user.setPassword("00100");

        /*userMapper.insert(user);*/

        userService.saveUser(user);
        //int i = 1 / 0;
    }

    @Transactional
    public void transactional() {
        User user = new User();
        user.setUserName("icho");
        user.setPassword("00100");


        int i = 1 / 0;
    }
}
