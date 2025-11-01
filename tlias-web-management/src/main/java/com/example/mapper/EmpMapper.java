package com.example.mapper;


import com.example.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


//员工信息
@Mapper
public interface EmpMapper {

//    @Select("select emp.*,dept.name deptname from emp left join dept on emp.id=dept.id order by create_time")
//    public List<Emp> Page();
//
//    @Select("select emp.*,dept.name deptname from emp left join dept on emp.id=dept.id  where emp.name like '%#{name}%'and\n" +
//            "gender=#{gender} and emp.entry_date between '#{begin}' and '#{end}' order by create_time")
//    public List<Emp> Page(String name, Integer gender, LocalDate begin, LocalDate end);
//      根据查询页面条件查询
      public List<Emp> Page(EmpQueryParam empqueryparam);



      //添加员工信息
      @Options(useGeneratedKeys = true,keyProperty = "id")
      @Insert("insert into emp(username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time) values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
      void addEmp(Emp emp);

      //根据id删除
      void deleteByid(List<Integer> ids);

      //根据id查询
      Emp findById(Integer id);

      //更新员工信息
      void update(Emp emp);

      //统计员工职位人数
      //创建新类JobStatistic来封装
//      List<JobStatistic> getJobOption();

      @MapKey("jobName")
      List<Map<String,Object>> getJobOption();
      //统计员工性别人数
      @MapKey("gender")
      List<Map<String,Object>> getGenderNum();

      @Select("select name from emp")
      List<String> getEmp();



//    @Select("select COUNT(*) from emp e left join dept d on e.dept_id=d.id;")
//    public Long getTotal();
//    @Select("select e.*,d.name deptname from emp e left join dept d on e.dept_id=d.id LIMIT #{start} ,#{pageSize}")
//    public List<Emp> Page(Integer start,Integer pageSize);
}
//select emp.*,dept.name deptname from emp left join dept on emp.id=dept.id order by create_time where name like '%${name}%'and
//gender=${gender} and emp.entry_date between '${entryDate1}' and '${entryDate2}'