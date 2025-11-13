package com.example.controller;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.Result;
import com.example.service.ClazzService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
@Tag(name = "班级管理", description = "班级增删改查")
public class ClazzController {


    @Autowired
    private ClazzService clazzService;

    @Operation(summary = "分页查询", description = "忘记了")
    @GetMapping
    public Result Page(ClazzQueryParam clazzQueryParam) {
//        log.info("分页查询{}", clazzQueryParam);
        return Result.success(clazzService.Page(clazzQueryParam));
    }

    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz) {
//        log.info("更新{}", clazz);
        clazzService.addClazz(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
//        log.info("查询班级id{}", id);
        return Result.success(clazzService.findById(id));
    }

    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz) {
//        log.info("更新{}", clazz);
        clazzService.updateClazz(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
//        log.info("删除班级id{}", id);
        clazzService.deletdById(id);
        return Result.success();
    }
    @GetMapping("/list")
    public Result list() {
//        log.info("查询所有班级");
        List<String> list = clazzService.list();
        return Result.success(list);
    }
}
