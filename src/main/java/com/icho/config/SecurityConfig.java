package com.icho.config;

import com.icho.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;

/**
 * @Author: icho
 * @Date: 2022/4/13 22:29
 * @Describe:
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Resource
    private PersistentTokenRepository persistentTokenRepository;

    //将密码加密器加到容器中
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 重写configure配置,将校验密码器注入到该bean中
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(getPasswordEncoder());
    }



    // 重写configure配置,编写权限校验规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.csrf().disable();

        http.formLogin()
                .loginPage("/loginPage") // 登录页面跳转请求
                .loginProcessingUrl("/login") // 登录发起的POST请求
                .successForwardUrl("/success") // 登录成功页面
                .failureForwardUrl("/fail") // 无权限页面
                .defaultSuccessUrl("/success").permitAll();

        http.exceptionHandling().accessDeniedPage("/fail");

        //退出
        http.logout()
                .logoutUrl("/logout") //退出的请求
                .logoutSuccessUrl("/loginPage").permitAll(); //退出成功之后跳转的页面

        // 开启记住我功能
        http.rememberMe()
                .tokenValiditySeconds(30) // 过期时间,s
                .tokenRepository(persistentTokenRepository) //令牌操作类
                .userDetailsService(userDetailsServiceImpl); //用户信息查询类

        /*
         hasAnyAuthority
         hasAuthority
         hasAnyRole
         hasRole
        */
        http.authorizeRequests() // 认证配置
                .antMatchers("/","/hello","/loginPage","login").permitAll() // 设置哪些路径可以直接访问,不需要认证
                .antMatchers("/findAll").hasAnyAuthority("menu:system") // 支持多个role
                .anyRequest() // 任何请求
                .authenticated() // 都需要身份认证
                .and().csrf().disable(); // 关闭cors
    }
}
