package com.example.service.impl;

import com.example.mapper.EmpLogMapper;
import com.example.pojo.EmpLog;
import com.example.service.EmpLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//需要在一个新的事务中运行 无论如何都会创建一个新事物
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class EmpLogServiceimpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;
    
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
