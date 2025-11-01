package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.JobOption;
import com.example.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    //分页查询
//    PageResult<Emp> Page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> Page(EmpQueryParam empQueryParam);

    void addEmp(Emp emp);

    void deleteByid(List< Integer> ids);

    Emp findById(Integer id);

    void update(Emp emp);

    List<String> getEmp();
}

