package com.icho.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: icho
 * @Date: 2022/3/2 22:00
 * @Describe:
 */
@Data
public class LoginBody {
    @NotBlank(message = "请填写账号")
    private String username;
    @NotBlank(message = "请填写密码")
    private String password;
    private String code;
    private String uuid;
    private String requestIp;
}
