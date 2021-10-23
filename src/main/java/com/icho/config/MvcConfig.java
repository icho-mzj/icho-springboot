package com.icho.config;

import com.icho.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: icho
 * @Date: 2021/9/16 18:48
 * @Describe: 定义配置类注册拦截器
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    // 重写接口中的addInterceptor方法,添加自定义拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 通过registry来注册拦截器,通过addPathPatterns来添加拦截路径
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }
}
