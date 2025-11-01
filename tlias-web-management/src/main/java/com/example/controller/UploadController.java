package com.example.controller;

import com.example.pojo.Result;
import com.example.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController

public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    //本地上传
//    @PostMapping("/upload")
//    public Result upload(String name , Integer age, MultipartFile file) throws IOException {
//        log.info("文件接受:{},{},{}",name,age,file);
//        //保存文件
//        //使用UUID生成文件名
//        String originalFilename = file.getOriginalFilename();
//        String extension = originalFilename.substring(file.getOriginalFilename().lastIndexOf("."));
//        String newFilename = UUID.randomUUID().toString()+ extension;
//        file.transferTo(new File("D:/javaweb/images/" + newFilename));
//        return Result.success();
//    }
    //往阿里云存储桶上传
    @PostMapping("/upload")
        public Result upload(MultipartFile file) throws Exception {
        log.info("文件接受:{}",file.getOriginalFilename());
        //将文件上传到OSS容器管理
        String url =aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
        log.info("文件上传成功的url:{}",url);
        return Result.success(url);
    }


}
