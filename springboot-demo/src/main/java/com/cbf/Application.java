package com.cbf;

import com.cbf.config.CommonConfig;
import com.cbf.config.LombokTestBean;
import com.cbf.config.TypeSecurityConfigProperties;
import com.cbf.config.TypeSecurityConfigYAML;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yingge
 * @Date 2022/9/11 18:40
 */
@RestController
@SpringBootApplication
@Slf4j
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @RequestMapping("/")
    String index(){
        return "Hello Spring Boot";
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(Application.class).bannerMode(Banner.Mode.OFF).run(args);
        CommonConfig commonConfig = applicationContext.getBean(CommonConfig.class);
        commonConfig.print();
        containsXMLTestService(applicationContext);
        testTypeSecurityConfig(applicationContext);
        testYAMLConfig(applicationContext);
        testLombokBean(applicationContext);
        System.exit(0);
    }

    public static void containsXMLTestService(ConfigurableApplicationContext applicationContext){
        log.info("contains: {}",applicationContext.containsBean("XMLTestService"));
    }

    public static void testTypeSecurityConfig(ConfigurableApplicationContext applicationContext){
        TypeSecurityConfigProperties config = applicationContext.getBean(TypeSecurityConfigProperties.class);
        log.info("name: {}", config.getName());
    }

    public static void testYAMLConfig(ConfigurableApplicationContext applicationContext){
        TypeSecurityConfigYAML yaml = applicationContext.getBean(TypeSecurityConfigYAML.class);
        log.debug("scb wife name: {}", yaml.getWife().getName());

    }
    public static void testLombokBean(ConfigurableApplicationContext applicationContext){
        LombokTestBean bean = applicationContext.getBean(LombokTestBean.class);
        log.info(bean.getName());
    }
}
