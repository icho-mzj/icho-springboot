package com.icho.bean;

import lombok.Data;

/**
 * @Author: icho
 * @Date: 2022/4/16 23:05
 * @Describe:
 */
@Data
public class Menu {
    private Long id;
    private String name;
    private String url;
    private Long parentId;
    private String permission;
}
