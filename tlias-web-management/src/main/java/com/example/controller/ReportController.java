package com.example.controller;


import com.example.pojo.ClazzOption;
import com.example.pojo.JobOption;
import com.example.pojo.Result;
import com.example.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;
    @GetMapping("/empJobData")
    public Result getJobOption() {
        log.info("请求获取员工职业数据...");
        JobOption jobOption=reportService.getJobOption();
        return Result.success(jobOption);
    }
    @GetMapping("/empGenderData")
    public  Result getGenderNum() {
        log.info("请求获取员工性别数据...");
        List<Map<String,Object>> genderlist =reportService.getGenderNum();
        return Result.success(genderlist);
    }
    @GetMapping("/studentDegreeData")
    public  Result getDegreeData() {
        log.info("请求获取学生学历数据...");
        List<Map<String,Object>> degreeData =reportService.getDegreeData();
        return Result.success(degreeData);
    }
    @GetMapping("/studentCountData")
    public  Result getClazzData() {
        log.info("请求获取学生班级数据...");
        ClazzOption clazzOption =reportService.getClazzData();
        return Result.success(clazzOption);
    }
}
