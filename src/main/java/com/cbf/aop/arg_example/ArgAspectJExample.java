package com.cbf.aop.arg_example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author yingge
 * @Date 2022/9/6 22:10
 */
@Aspect
@Component
public class ArgAspectJExample {

    @Pointcut("args(com.cbf.aop.arg_example.ArgFlyInterface)")
    public void parameterArgFly(){

    }
    @Before("parameterArgFly()")
    public void doBefore(){
        try {
            System.out.println("before fly method call, log it");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
