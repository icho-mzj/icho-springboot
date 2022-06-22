package com.icho.springsource.calTest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: icho
 * @Date: 2022/6/20 19:37
 * @Describe:
 */
@Aspect
@Component
public class LogAspectTest {

    @Pointcut("execution(* com.icho.springsource.calTest.*.*(..))") // 任意方法任意返回值
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法[" + methodName + "]之前执行<前置通知>,入参:" + Arrays.toString(joinPoint.getArgs()));
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法[" + methodName + "]之前执行<后置通知>,入参:" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()")
    public void methodAfterReturning(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法[" + methodName + "]之前执行<返回通知>,入参:" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法[" + methodName + "]之前执行<异常通知>,入参:" + Arrays.toString(joinPoint.getArgs()));
    }

    /*@Around(value = "pointCut()")
    public ProceedingJoinPoint methodAround(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法[" + methodName + "]之前执行<异常通知>,入参:"+ Arrays.toString(joinPoint.getArgs()));
        try {
            joinPoint.proceed();
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }*/


}
