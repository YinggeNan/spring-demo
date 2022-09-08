package com.cbf.aop.target_example;

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
public class TargetAspectJExample {

    @Pointcut("target(com.cbf.aop.target_example.TargetExampleInterface)")
    public void targetPointcut(){

    }
    @Before("targetPointcut()")
    public void doBefore(){
        try {
            System.out.println("before call method that object belong to TargetExampleInterface," +
                    " log it");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
