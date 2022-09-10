package com.cbf.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author yingge
 * @Date 2022/9/10 9:23
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file){ // 1.使用MultipartFile接受上传的文件
        try {
            // 2.使用FileUtils.writeByteArrayToFile快速写文件到磁盘
            FileUtils.writeByteArrayToFile(new File("D:\\tmp\\upload-save-dir\\" + file.getOriginalFilename()),file.getBytes());
            return "upload success";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
