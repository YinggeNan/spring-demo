package com.cbf.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author yingge
 * @Date 2022/9/7 19:23
 */
@Component
public class AwareService implements BeanNameAware, ResourceLoaderAware {
    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult(){
        System.out.printf("bean的名称为:%s\n",beanName);
        Resource resource = loader.getResource("classpath:/test.txt");
        try {
            System.out.printf("ResourceLoader加载的文件内容为:%s\n", IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
