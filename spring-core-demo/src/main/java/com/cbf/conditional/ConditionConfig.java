package com.cbf.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yingge
 * @Date 2022/9/7 22:32
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(WindowsCondition.class) // 通过Conditional注解,符合Windows条件就实例化windowsListService
    public ListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class) // 符合Linux条件就实例化linuxListService
    public ListService linuxListService(){
        return new LinuxListService();
    }
}
