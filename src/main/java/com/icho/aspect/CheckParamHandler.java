package com.icho.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: icho
 * @Date: 2022/6/13 18:35
 * @Describe:
 */
@Aspect
@Component
public class CheckParamHandler {

    @Pointcut("@annotation(com.icho.annotation.CheckParam) " + // 匹配带有指定注解的方法
            "|| " +
            "@within(com.icho.annotation.CheckParam)") // 匹配带有指定注解的方法
    public void proxyAspect() {
    }

    @Around("proxyAspect()")
    public Object doInvoke(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取类的字节码对象
        Class<?> clazz = joinPoint.getTarget().getClass();
        // 获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = clazz.getDeclaredMethod(signature.getName(), signature.getParameterTypes());



        return joinPoint.proceed();
    }
}
