package com.cbf.config;

import com.cbf.bean.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 1. 继承 AbstractHttpMessageConverter 实现自定义 HttpMessageConverter
 * @Author yingge
 * @Date 2022/9/10 9:47
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    public MyMessageConverter(){
        // 2.自定义媒体类型 application/x-wisely, 指定编码为 UTF-8
        super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
    }

    // 3. 重写 readInternal, 处理请求的数据, 表明将输入数据按照自定义处理方式并转成DemoObj对象
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new DemoObj(Long.valueOf(tempArr[0]), tempArr[1]);
    }

    // 4.表明本 HttpMessageConverter 只处理 DemoObj这个类
    // 即当 要访问的 api 接口处理的入参类是 DemoObj 类时才调用上面的readInternal方法
    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    // 5. 重写 writeInternal, 处理如何输出数据到 response,这里是 原样输出加上"hello:"
    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + obj.getId() + "-" + obj.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
