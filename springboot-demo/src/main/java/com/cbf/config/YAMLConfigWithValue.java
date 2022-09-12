package com.cbf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author yingge
 * @Date 2022/9/12 12:19
 */
@Configuration
@PropertySource(value = "classpath:type-security-config.yaml", factory = YamlPropertySourceFactory.class)
public class YAMLConfigWithValue {

    @Value("${scb.name}")
    private String scbName;

    @Value("${scb.wife.name}")
    private String scbWifeName;

    public void setScbName(String scbName) {
        this.scbName = scbName;
    }

    public void setScbWifeName(String scbWifeName) {
        this.scbWifeName = scbWifeName;
    }

    public String getScbName() {
        return scbName;
    }

    public String getScbWifeName() {
        return scbWifeName;
    }
}
