package com.icho;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: icho
 * @Date: 2022/3/4 0:23
 * @Describe:
 */
public class SpringSecurityTest {

    @Test
    public void bCryPasswordEncoder() {
        // 创建密码解析器
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        // 对密码进行加密 $2a$10$R4zB936QMUs9S5DOkKcX6OF9FMSJAom91GEcf2uCGmvhLw1G8KCyu
        String pwd = bCryptPasswordEncoder.encode("icho");
        System.out.println("pwd = " + pwd);
        // 判断原字符加密后和加密前是否匹配
        boolean b = bCryptPasswordEncoder.matches("icho", pwd);
        System.out.println("比较结果 = " + b);
    }
}
