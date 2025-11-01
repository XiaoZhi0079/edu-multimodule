package com.example.mapper;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    //条件查询
    List<Clazz> Page(ClazzQueryParam clazzQueryParam);

    void addClazz(Clazz clazz);

    Clazz findById(Integer id);

    void updateClazz(Clazz clazz);

    void deleteById(Integer id);
    //查询所有班级
    @Select("select clazz.name from clazz")
    List<String> list();

    @Select("select count(id) from student where clazz_id=#{id}")
    int countempid(Integer id);
}
