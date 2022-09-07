package com.cbf.bean_init_destroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author yingge
 * @Date 2022/9/7 11:55
 */
public class JSR250WayService{

    @PostConstruct
    public void init(){
        System.out.println("jsr250-init-method");
    }
    public JSR250WayService(){
        super();
        System.out.println("初始化构造函数-JSR250");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("jsr250-destroy-method");
    }
}
