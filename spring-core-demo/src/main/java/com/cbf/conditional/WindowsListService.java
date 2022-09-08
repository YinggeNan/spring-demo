package com.cbf.conditional;

/**
 * windows下创建的bean类
 * @Author yingge
 * @Date 2022/9/7 22:31
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
