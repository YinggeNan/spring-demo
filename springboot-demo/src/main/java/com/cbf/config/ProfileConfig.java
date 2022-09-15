package com.cbf.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yingge
 * @Date 2022/9/14 15:47
 */
@Configuration
@Slf4j
public class ProfileConfig {
//    @Value("${cbf.name}")
//    private String cbfName;

    @Value("${db.name}")
    private String dbName;

    @Value("${db.password}")
    private String dbPassword;
    @Value("${config-a.name}}")
    private String configAName;

    @Value("${config-b.name}")
    private String configBName;
    public void print(){
        log.info("db.name is {}",dbName);
        log.info("db.password is {}", dbPassword);
        log.info("config-a name is {}",configAName);
        log.info("config-b name is {}",configBName);
//        log.info("cbf.name is {}",cbfName);
    }
}
