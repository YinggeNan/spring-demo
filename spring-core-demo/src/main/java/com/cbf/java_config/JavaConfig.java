package com.cbf.java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yingge
 * @Date 2022/9/7 17:59
 */
@Configuration
public class JavaConfig {
    @Bean // 表明当前方法的返回值是一个bean, bean的名称是方法名
    public FunctionService functionService(){
        return new FunctionService();
    }
    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService()); // 注入bean的时候直接调用方法
        return useFunctionService;
    }

    /**
     *  只要容器存在某个bean,就可以在另一个bean声明方法中的参数中直接写入
     * @param functionService
     * @return
     */
    @Bean
    public UseFunctionService useFunctionService(FunctionService functionService){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService);
        return useFunctionService;
    }
}
