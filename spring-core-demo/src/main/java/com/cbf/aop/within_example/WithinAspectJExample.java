package com.cbf.aop.within_example;

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
public class WithinAspectJExample {

    @Pointcut("within(com.cbf.aop.within_example.WithinExampleInterface)")
    public void withinPointcut(){

    }
    @Before("withinPointcut()")
    public void doBefore(){
        try {
            System.out.println("before call method that object belong to WithinExampleInterface," +
                    " log it");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
