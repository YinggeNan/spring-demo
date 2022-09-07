package com.cbf.conditional;

/**
 * Linux下所要创建的Bean的类
 * @Author yingge
 * @Date 2022/9/7 22:32
 */
public class LinuxListService implements ListService{
    @Override
    public String showListCmd() {
        return "ls";
    }
}
