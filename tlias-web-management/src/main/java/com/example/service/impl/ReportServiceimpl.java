package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.mapper.StudentMapper;
import com.example.pojo.ClazzOption;
import com.example.pojo.JobOption;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceimpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public JobOption getJobOption() {
        List<Map<String,Object>> list = empMapper.getJobOption();
        JobOption jobOption = new JobOption();
        jobOption.setJobList(list.stream().map(map -> map.get("jobName")).toList());
        jobOption.setDataList(list.stream().map(map -> map.get("count")).toList());
        return jobOption;
    }

    @Override
    public List<Map<String,Object>> getGenderNum() {
         return empMapper.getGenderNum();
    }

    @Override
    public List<Map<String, Object>> getDegreeData() {
        return studentMapper.getDegreeData();
    }

    @Override
    public ClazzOption getClazzData() {
        List<Map<String, Object>> list=studentMapper.getClassData();
        ClazzOption clazzOption = new ClazzOption();
        clazzOption.setClazzList(list.stream().map(map -> map.get("name")).toList());
        clazzOption.setDataList(list.stream().map(map -> map.get("count")).toList());
        return clazzOption;
    }
}
