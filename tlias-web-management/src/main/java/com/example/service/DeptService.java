package com.example.service;


import com.example.pojo.Dept;

import java.util.List;


public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void addDept(Dept dept);

    Dept findById(Integer id);

    void updateDept(Dept dept);

}
