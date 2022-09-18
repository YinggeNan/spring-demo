package com.cbf.interface_all_implement;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Author yingge
 * @Date 2022/9/16 21:53
 */
@Configuration
@ComponentScan("com.cbf.interface_all_implement")
public class JavaConfig implements ApplicationContextAware {
    private Map<String, SpringGetAllTestInterface> beansOfType;

    @Autowired
    private Map<String, SpringGetAllTestInterface> beansOfType1;

    public Map<String, SpringGetAllTestInterface> getBeansOfType() {
        return beansOfType;
    }

    public Map<String, SpringGetAllTestInterface> getBeansOfType1() {
        return beansOfType1;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        beansOfType = applicationContext.getBeansOfType(SpringGetAllTestInterface.class);
    }
}
