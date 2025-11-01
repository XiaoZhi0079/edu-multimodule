package com.example.mapper;


import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {


    @Select("select id,name,username from emp where username=#{username} and password=#{password}")
    Emp select(Emp emp);
}
