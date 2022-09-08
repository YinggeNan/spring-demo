package com.cbf.spring_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author yingge
 * @Date 2022/9/8 16:30
 */
@Configuration
public class TestConfig {

    @Bean
    @Profile(("dev"))
    public TestBean devTestBean(){
        return new TestBean("from development profile");
    }

    @Bean
    @Profile("prod")
    public TestBean prodTestBean(){
        return new TestBean("from production profile");
    }
}
