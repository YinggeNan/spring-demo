package com.cbf.aop.this_example;

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
public class ThisAspectJExample {

    @Pointcut("this(com.cbf.aop.this_example.ThisExampleInterface)")
    public void thisPointcut(){

    }
    @Before("thisPointcut()")
    public void doBefore(){
        try {
            System.out.println("before call method that object belong to ThisExampleInterface," +
                    " log it");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
