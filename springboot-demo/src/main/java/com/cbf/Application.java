package com.cbf;

import com.cbf.config.CommonConfig;
import com.cbf.config.TypeSecurityConfigProperties;
import com.cbf.config.TypeSecurityConfigYAML;
import com.cbf.config.YAMLConfigWithValue;
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
public class Application {

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
    }

    public static void containsXMLTestService(ConfigurableApplicationContext applicationContext){
        System.out.printf("contains: %s",applicationContext.containsBean("XMLTestService"));
    }

    public static void testTypeSecurityConfig(ConfigurableApplicationContext applicationContext){
        TypeSecurityConfigProperties config = applicationContext.getBean(TypeSecurityConfigProperties.class);
        System.out.printf("\nname: %s", config.getName());
    }

    public static void testYAMLConfig(ConfigurableApplicationContext applicationContext){
        TypeSecurityConfigYAML yaml = applicationContext.getBean(TypeSecurityConfigYAML.class);
        System.out.printf("\nscb wife name: %s", yaml.getWife().getName());
    }
}
