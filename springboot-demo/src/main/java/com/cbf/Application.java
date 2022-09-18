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
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
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
        ThymeleafAutoConfiguration con;
        return "Hello Spring Boot";
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).bannerMode(Banner.Mode.OFF).run(args);
    }

}
