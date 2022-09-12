package com.cbf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author yingge
 * @Date 2022/9/12 9:52
 */
@Configuration
@ImportResource(locations = "classpath:sample.xml")
public class CommonConfig {

    @Value("${name}")
    private String name;

    public void print(){
        System.out.printf("name is %s",name);
    }
}
