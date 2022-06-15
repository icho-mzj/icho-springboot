package com.icho.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: icho
 * @Date: 2022/5/16 20:52
 * @Describe:
 */
@Slf4j
@Component
public class UserInfoInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!"OPTIONS".equals(request.getMethod())) {
            String accessToken = request.getHeader("accessToken");
            if (log.isDebugEnabled()) {
                log.debug("accessToken: " + accessToken);
            }

            // JWT解密token
            // 根据JWT解密的token构建UserAuthInfo
            // 将UserAuthInfo放入UserContext
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        // 移除当前线程数据,防止ThreadLocal无限扩大
        UserContext.remove();
    }
}
