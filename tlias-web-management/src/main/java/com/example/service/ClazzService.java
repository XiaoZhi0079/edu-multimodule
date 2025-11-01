package com.example.service;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> Page(ClazzQueryParam clazzQueryParam);

    void addClazz(Clazz clazz);

    Clazz findById(Integer id);

    void updateClazz(Clazz clazz);

    void deletdById(Integer id);

    List<String> list();
}
