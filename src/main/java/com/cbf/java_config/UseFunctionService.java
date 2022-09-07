package com.cbf.java_config;

/**
 * @Author yingge
 * @Date 2022/9/7 17:58
 */
// 此处没有@Configuration注解声明bean
public class UseFunctionService {
    // 此处没有使用@Autowired注解注入bean
    FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
