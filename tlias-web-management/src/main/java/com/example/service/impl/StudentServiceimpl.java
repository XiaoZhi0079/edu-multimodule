package com.example.service.impl;

import com.example.mapper.StudentMapper;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import com.example.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class StudentServiceimpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> Page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        List<Student> rows = studentMapper.Page(studentQueryParam);
        Page<Student> pageresult = (Page<Student>) rows;
        log.info("开始处理分页查询");
        return new PageResult<>(pageresult.getTotal(), rows);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void addStudent(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        student.setViolationCount(0);
        student.setViolationScore(0);
        log.info("开始添加学生");
        studentMapper.addStudent(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }

    @Override
    public void updateViolation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }

    @Override
    public void deleteById(List<Integer> ids) {
        studentMapper.deleteById(ids);
    }
}
