package com.example.service;

import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> Page(StudentQueryParam studentQueryParam);

    void addStudent(Student student);

    Student findById(Integer id);

    void updateStudent(Student student);

    void updateViolation(Integer id, Integer score);

    void deleteById(List<Integer> ids);
}
