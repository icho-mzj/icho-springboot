package com.icho.springsource.transaction.entity;

import lombok.Data;

/**
 * @Author: icho
 * @Date: 2022/6/29 19:29
 * @Describe:
 */
@Data
public class AccountInfo {
    private Integer id;
    private String accountId;
    private double balance;
}
