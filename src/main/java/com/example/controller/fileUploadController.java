package com.example.controller;

import com.example.pojo.Result;
import com.example.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
public class fileUploadController {

    // 文件上传
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        // 获取原始的文件名
        String originalFilename = file.getOriginalFilename();
        // 构造唯一的文件名
        String extName = UUID.randomUUID().toString().substring(originalFilename.lastIndexOf("."));
        // extName是生成的UUID, originalFilename是文件名称和后缀
        String fileName = extName + originalFilename;

        String url = AliOssUtil.uploadFile(fileName, file.getInputStream());
        return Result.success(url);
    }
}
