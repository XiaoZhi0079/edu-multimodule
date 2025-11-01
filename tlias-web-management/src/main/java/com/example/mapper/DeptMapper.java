package com.example.mapper;


import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
//    1.手动结果映射
/*    @Results({
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "create_time", property = "createTime")})*/
//    2.起别名
//    @Select("select id,name,create_time createTime,update_time updateTime from dept order by create_time  desc ")
    @Select("select id,name,create_time,update_time from dept order by create_time  desc ")
//    3.开启驼峰命名
    List<Dept> findAll();

    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void addDept(Dept dept);

    @Select("select id,name,create_time,update_time from dept where id=#{id}")
    Dept findById(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void updateDept(Dept dept);

    @Select("select count(id) from emp where dept_id=#{id};")
    int countempid(Integer id);
}
