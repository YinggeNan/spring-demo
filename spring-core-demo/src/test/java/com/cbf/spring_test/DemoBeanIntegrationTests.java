package com.cbf.spring_test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author yingge
 * @Date 2022/9/8 16:32
 */
@RunWith(SpringJUnit4ClassRunner.class) // 1.在Junit环境下提供Spring TestContext Framework功能
@ContextConfiguration(classes = {TestConfig.class}) // 2.加载ApplicationContext, classes属性指定加载配置类
@ActiveProfiles("prod") // 3.声明活动的profiles,改为 "dev"可得到不通过的结果
public class DemoBeanIntegrationTests {
    @Autowired // 4.可使用普通的 @Autowired 来注入bean
    private TestBean testBean;

    @Test // 测试代码,通过JUnit的 Assert来校验结果是否和预期的一致
    public void prodBeanShouldInject(){
        String expected = "from production profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected, actual);
    }
}
