package com.icho.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: icho
 * @Date: 2021/9/16 16:58
 * @Describe: Mybatis
 */
@Data
@Table(name = "t_user")
public class User {
    // id
    @Id
    @KeySql(useGeneratedKeys = true) // 开启自增主键回显功能
    private Long id;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 性别，1男性，2女性
    private Integer sex;
    // 出生日期
    private Date birthday;
    // 创建时间
    private Date created;
    // 更新时间
    private Date updated;
    // 备注
    private String note;
}
