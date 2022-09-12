package com.cbf;

import com.cbf.config.MyMvcConfig;
import com.cbf.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @Author yingge
 * @Date 2022/9/11 9:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
// 1.声明加载的 ApplicationContext是一个 WebApplicationContext,属性值是 web资源的位置, 默认为 src/main/webapp,本例子修改为 src/main/resources
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegration {
    // 2.模拟mvc对象,通过 MockMvcBuilders.webAppContextSetup(this.wac).build()初始化
    private MockMvc mockMvc;
    // 3.可以在测试中注入spring 的bean
    @Autowired
    private DemoService demoService;

    // 4.可注入 WebApplicationContext
    @Autowired
    WebApplicationContext wac;

    // 5.可以注入模拟的 http session,此处仅演示,没使用
    @Autowired
    MockHttpSession session;

    // 6.可注入模拟的  http servlet,此处仅演示,没使用
    @Autowired
    MockHttpServletRequest request;

    // 7.@Before在测试开始前进行初始化工作
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testNormalController() throws Exception{
        mockMvc.perform(get("/normal")) // 8.模拟向 /normal 进行get请求
                .andExpect(status().isOk()) // 9.预期控制返回状态为200
                .andExpect(view().name("page")) // 10.预期view名称为page
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp")) // 11.预期页面转向的真正路径为/WEB-INF/classes/views/page.jsp
                .andExpect(model().attribute("msg", demoService.saySomething())); // 12.预期model里的值是 demoService.saySomething()返回值hello

    }
    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRest")) // 13.模拟向 /testRest进行get请求
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8")) // 14.预期返回值的媒体类型为 text/plain;charset=UTF-8
                .andExpect(content().string(demoService.saySomething())); // 15.预期返回值内容为 demoService.saySomething()
    }
}
