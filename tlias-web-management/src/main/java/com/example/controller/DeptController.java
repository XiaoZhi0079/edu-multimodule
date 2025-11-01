package com.example.controller;
import com.example.anno.LogOpeartion;
import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptservice;
    //    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
//        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptservice.findAll();
        return Result.success(deptList);
    }

    //方式一：使用HttpServletRequest获取id参数
//  @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request){
//        Integer id=Integer.parseInt(request.getParameter("id"));
//        System.out.println("删除部门数据"+id);
////        deptservice.delete(id);
//        return Result.success();
//  }
    //方式二：使用@RequestParam获取id参数  一旦声明了RequestParam注解，那么参数值必须传递，除非将require值设为false
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam("id") Integer deptId){
//        System.out.println("删除部门数据"+deptId);
////        deptservice.delete(id);
//        return Result.success();
//  }
    //方式三：当前端传参参数名和服务器方法形参一致时，可以省略@RequestParam注解
    @LogOpeartion
    @DeleteMapping
    public Result deleteById(Integer id) {
        log.info("删除部门数据" + id);
//        System.out.println("删除部门数据" + id);
        deptservice.deleteById(id);
        return Result.success();
    }

    @LogOpeartion
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("增加部门" + dept.getName());
//        System.out.println("增加部门"+dept.getName());
        deptservice.addDept(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        log.info("查询部门id为"+id);
//        System.out.println("查询部门id为"+id);
        Dept dept=deptservice.findById(id);
        return Result.success(dept);
    }

    @LogOpeartion
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门" + dept.getName());
//        System.out.println("修改部门"+dept.getName());
        deptservice.updateDept(dept);
        return Result.success();
    }
}
//@RestController
//public class Deptcontroller {
//    @Autowired
//    private Deptservice deptservice;
//    //    @RequestMapping(value = "/depts",method = RequestMethod.GET)
//    @GetMapping("/depts")
//    public Result list() {
//        System.out.println("查询全部部门数据");
//        List<Dept> deptList = deptservice.findAll();
//        return Result.success(deptList);
//    }
//
//    //方式一：使用HttpServletRequest获取id参数
////  @DeleteMapping("/depts")
////    public Result delete(HttpServletRequest request){
////        Integer id=Integer.parseInt(request.getParameter("id"));
////        System.out.println("删除部门数据"+id);
//////        deptservice.delete(id);
////        return Result.success();
////  }
//    //方式二：使用@RequestParam获取id参数  一旦声明了RequestParam注解，那么参数值必须传递，除非将require值设为false
////    @DeleteMapping("/depts")
////    public Result delete(@RequestParam("id") Integer deptId){
////        System.out.println("删除部门数据"+deptId);
//////        deptservice.delete(id);
////        return Result.success();
////  }
//    //方式三：当前端传参参数名和服务器方法形参一致时，可以省略@RequestParam注解
//    @DeleteMapping("/depts")
//    public Result deleteById(Integer id) {
//        System.out.println("删除部门数据" + id);
//        deptservice.deleteById(id);
//        return Result.success();
//    }
//
//    @PostMapping("/depts")
//    public Result addDept(@RequestBody Dept dept) {
//        System.out.println("增加部门"+dept.getName());
//        deptservice.addDept(dept);
//        return Result.success();
//    }
//    @GetMapping("/depts/{id}")
//    public Result findById(@PathVariable Integer id) {
//        System.out.println("查询部门id为"+id);
//        Dept dept=deptservice.findById(id);
//        return Result.success(dept);
//    }
//    @PutMapping("/depts")
//    public Result updatedept(@RequestBody Dept dept) {
//        System.out.println("修改部门"+dept.getName());
//        deptservice.updateDept(dept);
//        return Result.success();
//    }
//}
