package com.cbf.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @Author yingge
 * @Date 2022/9/7 18:33
 */
@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;

    /**
     * 用applicationContext.publishEvent()来发布事件
     * @param msg
     */
    public void publish(String msg){
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }
}
