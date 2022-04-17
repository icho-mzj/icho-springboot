/*
package com.icho.common;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

*/
/**
 * @Author: icho
 * @Date: 2022/4/17 1:51
 * @Describe:
 *//*

@Component
public class DefaultPasswordEncoder implements PasswordEncoder {
    public DefaultPasswordEncoder() {
        this(-1);
    }
    */
/**
     * @param strength
     * the log rounds to use, between 4 and 31
     *//*

    public DefaultPasswordEncoder(int strength) {
    }
    //进行md5加密
    @Override
    public String encode(CharSequence rawPassword) {
        String encrypt = MD5.encrypt(rawPassword.toString());
        return encrypt;
    }

    */
/**
     * 进行密码比对
     * @param rawPassword 数据库的加密过的密码
     * @param encodedPassword 要加密的密码
     * @return
     *//*

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null || encodedPassword.length() == 0) {
            return false;
        }
        boolean result = encodedPassword.equals(MD5.encrypt(rawPassword.toString()));
        System.out.println("密码对比结果:"+result);
        return result;
    }
}
*/
