package com.example.service.impl;

import com.example.exception.ClazzRuntimeException;
import com.example.mapper.ClazzMapper;
import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.PageResult;

import com.example.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ClazzServiceimpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> Page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> rows = clazzMapper.Page(clazzQueryParam);
        Page<Clazz> pageresult = (Page<Clazz>) rows;
        PageResult<Clazz> pageResult = new PageResult<>(pageresult.getTotal(), pageresult.getResult());
        return pageResult;
    }

    @Override
    public void addClazz(Clazz clazz) {
        log.info("添加{}", clazz);
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazz(clazz);
    }

    @Override
    public Clazz findById( Integer id) {
        return clazzMapper.findById(id);
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateClazz(clazz);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deletdById(Integer id) {
        if(clazzMapper.countempid(id)>0){
            throw new ClazzRuntimeException("该班级下有员工，不能删除");
        }
        clazzMapper.deleteById(id);
    }

    @Override
    public List<String> list() {
        List<String> list = clazzMapper.list();
        return list;
    }
}
