package com.cbf.service;

import com.cbf.config.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Author yingge
 * @Date 2022/9/14 16:17
 */
@Service
@Slf4j
public class TestService implements CommandLineRunner {

    @Autowired
    private TypeSecurityConfigProperties typeSecurityConfigProperties;
    @Autowired
    private TypeSecurityConfigYAML typeSecurityConfigYAML;
    @Autowired
    private LombokTestBean lombokTestBean;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private CommonConfig commonConfig;

    @Autowired
    private ProfileConfig profileConfig;

    @Override
    public void run(String... args) throws Exception {
        commonConfig.print();
        log.info("contains: {}",applicationContext.containsBean("XMLTestService"));
        log.info("name: {}", typeSecurityConfigProperties.getName());
        log.debug("scb wife name: {}", typeSecurityConfigYAML.getWife().getName());
        log.info("lombokTestBean name is : {}", lombokTestBean.getName());
        profileConfig.print();
    }
}
