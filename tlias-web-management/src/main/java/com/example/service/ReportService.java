package com.example.service;

import com.example.pojo.ClazzOption;
import com.example.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService{

    JobOption getJobOption();

    List<Map<String,Object>> getGenderNum();

    List<Map<String, Object>> getDegreeData();

    ClazzOption getClazzData();
}
