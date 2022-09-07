package com.cbf.el_spring;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @Author yingge
 * @Date 2022/9/7 8:10
 */
@Configuration
@ComponentScan(basePackages = "com.cbf.el_spring")
// 注意classpath和后面的路径之间不能有空格,且要有分隔符/
@PropertySource(value = "classpath:/test/test.properties")
public class ELConfig {
    @Value("I Love You!") //1.注入普通字符串
    private String normal;

    @Value("#{systemProperties['os.name']}") //2.注入操作系统属性
    private String osName;

    @Value("#{ T(java.lang.Math).random() * 100.0}") //3.注入表达式结果
    private double randomNumber;

    @Value("#{demoService.another}") //4.注入其他bean属性
    private String fromAnother;

    @Value("classpath:test.txt") //5.注入文件资源
    private Resource testFile;

    @Value("http://www.baidu.com") //6.注入网址资源
    private Resource testURL;

    @Value("${book.name}") //7.注入配置文件
    private String bookName;

    @Autowired
    private Environment environment;

    /**
     * spring4.3之前除了使用@PropertySource注解之外,
     * 还要手动注册一个资源文件解析器PropertySourcesPlaceholderConfigurer到IOC容器中。不然无法解析
     * 并且如果使用Bean注解注册资源文件解析器，方法要是static方法。
     *
     * spring 4.3之后可以直接使用, 因为spring会使用默认的DefaultPropertySourceFactory解析。
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testURL.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
