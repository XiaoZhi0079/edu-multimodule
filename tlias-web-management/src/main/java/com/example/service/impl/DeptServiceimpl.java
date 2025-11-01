package com.example.service.impl;


import com.example.exception.DeptRuntimeException;
import com.example.mapper.DeptMapper;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceimpl implements DeptService {

    @Autowired
    private DeptMapper deptmapper;

    @Override
    public List<Dept> findAll() {
        return deptmapper.findAll();
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        if (deptmapper.countempid(id)>0) {
            throw new DeptRuntimeException("部门下有员工，不能删除");}
        else{
                deptmapper.deleteById(id);
            }
        }

    @Override
    public void addDept(Dept dept) {
        //1.补全基础属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.addDept(dept);
    }

    @Override
    public Dept findById(Integer id) {

        return deptmapper.findById(id);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.updateDept(dept);
    }
}
