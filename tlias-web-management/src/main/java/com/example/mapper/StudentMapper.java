package com.example.mapper;

import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
//    分页查询
    List<Student> Page(StudentQueryParam studentQueryParam);

//    添加学生
    void addStudent(Student student);

//    @Select("select id from clazz where name = #{clazzName}")
//    Integer selectByClazzName(String clazzName);

//    查询回显
    @Select("select student.* from student where id = #{id}")
    Student findById(Integer id);

 
    void updateStudent(Student student);

    void updateViolation(Integer id, Integer score);

    void deleteById(List<Integer> ids);

    @MapKey("name")
    List<Map<String, Object>> getDegreeData();

    @MapKey("name")
    List<Map<String, Object>> getClassData();
}
