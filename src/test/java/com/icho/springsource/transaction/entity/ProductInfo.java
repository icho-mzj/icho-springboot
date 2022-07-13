package com.icho.springsource.transaction.entity;

import lombok.Data;

/**
 * @Author: icho
 * @Date: 2022/6/29 19:28
 * @Describe:
 */
@Data
public class ProductInfo {
    private Integer productId;
    private String productName;
    private Integer store;
}
