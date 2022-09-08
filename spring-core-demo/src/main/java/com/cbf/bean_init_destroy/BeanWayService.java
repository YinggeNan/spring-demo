package com.cbf.bean_init_destroy;

/**
 * @Author yingge
 * @Date 2022/9/7 11:53
 */
public class BeanWayService {
    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService(){
        super();
        System.out.println("初始化构造函数—BeanWayService");
    }
    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }
}
