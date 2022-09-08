package com.cbf.bean;

/**
 * @Author yingge
 * @Date 2022/9/8 22:57
 */
public class DemoObj {
    private Long id;
    private String name;

    /**
     * jackson 对 对象和json转换时一定需要一个无参构造函数
     */
    public DemoObj(){
        super();
    }
    public DemoObj(Long id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
