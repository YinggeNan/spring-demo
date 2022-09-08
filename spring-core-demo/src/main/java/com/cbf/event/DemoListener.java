package com.cbf.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 实现ApplicationListener接口,并监听指定类型的事件
 * 事件监听器
 * @Author yingge
 * @Date 2022/9/7 18:31
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    /**
     * onApplicationEvent方法接受消息
     * @param demoEvent
     */
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("get msg!");
        System.out.printf("我(bean-demoListener) 收到了 the msg:\"%s\" sent by bean-demoPublisher", msg);
    }
}

