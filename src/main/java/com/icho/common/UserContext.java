package com.icho.common;

import com.icho.bean.UserAuthInfo;

/**
 * @Author: icho
 * @Date: 2022/5/16 20:55
 * @Describe: 用户上下文
 */
public class UserContext {

    private final static ThreadLocal<UserAuthInfo> user = new ThreadLocal<>();

    public static UserAuthInfo getUser() {
        return user.get();
    }

    public static void setUser(UserAuthInfo userAuthInfo) {
        user.set(userAuthInfo);
    }

    public static void remove() {
        user.remove();
    }

}
