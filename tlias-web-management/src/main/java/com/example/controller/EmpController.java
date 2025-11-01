package com.example.controller;

import com.example.anno.LogOpeartion;
import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
//    @GetMapping
//    public Result Page(@RequestParam (defaultValue = "1") Integer page,@RequestParam (defaultValue = "10")Integer pageSize)
//    {
//        log.info("分页查询{},{}",page,pageSize);
//        PageResult<Emp> pageResult = empService.Page(page, pageSize);
//        return Result.success(pageResult);
//    }
@GetMapping
//public Result Page(@RequestParam (defaultValue = "1") Integer page, @RequestParam (defaultValue = "10")Integer pageSize, @RequestParam String name, @RequestParam Integer gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end)
public Result Page(EmpQueryParam empqueryparam)
{
    log.info("分页查询{}",empqueryparam);
    PageResult<Emp> pageResult = empService.Page(empqueryparam);
    return Result.success(pageResult);
}
@LogOpeartion
@PostMapping
    public Result add(@RequestBody Emp emp){
    log.info("添加员工{}",emp);
    empService.addEmp(emp);
    return Result.success();
}
//    @PostMapping
//    public Result addEmp(@RequestBody Emp emp)

//    @DeleteMapping
//    public Result delete(Integer[] ids){
//    log.info("删除员工的id为:{}", Arrays.toString(ids));
//    empService.delete(ids);
//    return Result.success();
//}
@LogOpeartion
@DeleteMapping
public Result delete(@RequestParam List<Integer>ids){
    log.info("删除员工的id为:{}",ids);
    empService.deleteByid(ids);
    return Result.success(ids);
}

@GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
    log.info("查询员工的id为:{}",id);
    Emp emp = empService.findById(id);
    log.info("查询员工为:{}",emp);
    return Result.success(emp);
}
@LogOpeartion
@PutMapping
    public Result update(@RequestBody Emp emp){
    log.info("更新员工{}",emp);
    empService.update(emp);
    return Result.success();
}
@GetMapping("/list")
    public Result getEmp(){
    log.info("查询所有员工");
    List<String> list = empService.getEmp();
    return Result.success(list);
}
}
