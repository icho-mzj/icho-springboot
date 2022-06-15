package com.icho.annotation;

import java.lang.annotation.*;

/**
 * @Author: icho
 * @Date: 2022/6/13 18:39
 * @Describe:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckParam {
}
