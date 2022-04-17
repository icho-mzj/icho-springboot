package com.icho.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: icho
 * @Date: 2021/9/16 16:58
 * @Describe: Mybatis
 */
@Data
public class User {
    // id
    @ApiModelProperty(value = "id")
    private Long id;
    // 用户名
    @ApiModelProperty(value = "用户名")
    private String userName;
    // 密码
    @ApiModelProperty(value = "密码")
    @NotNull
    @Length(max = 20)
    private String password;
    // 姓名
    @ApiModelProperty(value = "姓名")
    private String name;
    // 年龄
    @ApiModelProperty(value = "年龄")
    private String age;
    // 性别，1男性，2女性
    @ApiModelProperty(value = "性别，1男性，2女性")
    private String sex;
    // 出生日期
    @ApiModelProperty(value = "出生日期")
    private Date birthday;
    // 创建时间
    @ApiModelProperty(value = "创建时间")
    private Date created;
    // 更新时间
    @ApiModelProperty(value = "更新时间")
    private Date updated;
    // 备注
    @ApiModelProperty(value = "备注")
    private String note;

    @Max(10)
    @Min(10)
    @ApiModelProperty(value = "级别")
    private Integer level;
    @ApiModelProperty(value = "vip")
    private Integer vip;
}
