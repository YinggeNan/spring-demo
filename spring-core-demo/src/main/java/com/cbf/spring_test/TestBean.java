package com.cbf.spring_test;

/**
 * @Author yingge
 * @Date 2022/9/8 16:10
 */
public class TestBean {

    private String content;
    public TestBean(String content){
        super();
        this.content= content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
