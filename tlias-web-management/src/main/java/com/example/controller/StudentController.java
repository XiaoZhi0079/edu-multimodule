package com.example.controller;

import com.example.anno.LogOpeartion;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import com.example.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
   @GetMapping
    public Result Page(StudentQueryParam studentQueryParam){
       log.info("分页查询");
       PageResult<Student> pageResult=studentService.Page(studentQueryParam);
       return Result.success(pageResult);
   }
   @LogOpeartion
   @PostMapping
    public Result add(@RequestBody Student student){
       log.info("添加学生");
       studentService.addStudent(student);
       return Result.success();
   }
   @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
       log.info("查询学生");
       Student student=studentService.findById(id);
       return Result.success(student);
   }
   @LogOpeartion
   @PutMapping
    public Result update(@RequestBody Student student){
       log.info("修改学生");
       studentService.updateStudent(student);
       return Result.success();
   }
   @PutMapping("violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id,@PathVariable Integer score){
       log.info("违纪处理");
       studentService.updateViolation(id,score);
       return Result.success();
    }
    @LogOpeartion
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
       log.info("删除学生");
       studentService.deleteById(ids);
       return Result.success();
    }
}
