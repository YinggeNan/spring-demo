package com.cbf.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author yingge
 * @Date 2022/9/7 16:19
 */
@Configuration
public class ProfileConfig {
    @Bean
    @Profile("dev") // profile为dev时初始化devDemoBean
    public DemoBean devDemoBean(){
        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod") // profile为prod时初始化prodDemoBean
    public DemoBean prodDemoBean(){
        return new DemoBean("from production profile");
    }
}
