package com.icho.bean;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

/**
 * @Author: icho
 * @Date: 2022/1/14 16:27
 * @Describe:
 */
@Data
@FieldNameConstants
public class BaseEntity {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
