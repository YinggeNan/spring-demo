package com.cbf.aop.arg_annotation_example;

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
public class ArgAnnotationAspectJExample {

    @Pointcut("@args(com.cbf.aop.arg_annotation_example.ArgFlyAnnotation)")
    public void parameterArgFly(){

    }
    @Before("parameterArgFly()")
    public void doBefore(){
        try {
            System.out.println("before call method that parameter annotated by ArgFlyAnnotation," +
                    " log it");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
