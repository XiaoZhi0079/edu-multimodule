package com.example.service.impl;

import com.example.mapper.EmpExprMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.*;
import com.example.service.EmpLogService;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@Slf4j
@Service
public class EmpServiceimpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;


//    public PageResult<Emp> Page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end)
public PageResult<Emp> Page(EmpQueryParam empqueryparam)
    {
        //原始分页查询
//        Long total = empMapper.getTotal();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.Page(start, pageSize);
//        return new PageResult<Emp>(total,rows);
        //基于PageHelper分页查询
        //在使用PageHelper时sql语句不能使用分号
        //PageHelper仅仅对其下一个语句进行处理
        PageHelper.startPage(empqueryparam.getPage(),empqueryparam.getPageSize());
        List<Emp> rows = empMapper.Page(empqueryparam);
        Page<Emp> pageresult = (Page<Emp>) rows;
                              // 4. 返回这个对象
        return new PageResult<Emp>(pageresult.getTotal(), pageresult.getResult());
    }
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void addEmp(Emp emp) {

            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.addEmp(emp);
            log.info("empid为{}",emp.getId());



            List<EmpExpr> empExprsList = emp.getExprList();
            log.info("empExprsList为{}",empExprsList);
            if(!CollectionUtils.isEmpty(empExprsList)){
                empExprsList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.addEmpExprsBatch(empExprsList);
            }

            empLogService.insertLog(new EmpLog(emp.getId(),LocalDateTime.now(),"添加员工"+emp.getName()));


    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void deleteByid(List<Integer> ids) {
        //删除员工基础信息
        empMapper.deleteByid(ids);
        log.info("删除员工的id为:{}",ids);
        //删除员工工作经历信息
        empExprMapper.deleteByempid(ids);
    }

    @Override
    public Emp findById(Integer id) {
    Emp emp = empMapper.findById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
    //更新员工基础信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    //更新员工工作经历
//        1. 删除员工工作经历
//        调用上述删除方法，将单个id转为列表
        empExprMapper.deleteByempid(Arrays.asList(emp.getId()));
//        empExprMapper.deleteByempid(List.of(emp.getId()));
//        2. 添加员工工作经历
        List<EmpExpr>empExprsList = emp.getExprList();
        if(!CollectionUtils.isEmpty(empExprsList)){
            empExprsList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.addEmpExprsBatch(empExprsList);
        }

        empLogService.insertLog(new EmpLog(emp.getId(),LocalDateTime.now(),"添加员工"+emp.getName()));

    }

    @Override
    public List<String> getEmp() {
    log.info("查询所有员工");
    List<String> list = empMapper.getEmp();
    log.info("查询结果为{}",list);
        return list;
    }

//    @Override
//    public JobOption getJobOption() {
//        // 1. 从Mapper获取原始的、按行排列的统计数据列表
//        List<JobStatistic> statsList = empMapper.getJobOption();
//
//        // 2. 准备最终要返回的 JobOption 对象和它内部的两个列表
//        JobOption finalJobOption = new JobOption();
//        List<String> names = new ArrayList<>();
//        List<Integer> values = new ArrayList<>();
//
//        // 3. 遍历原始数据列表，将数据分别装入两个新列表中
//        for (JobStatistic dto : statsList) {
//            names.add(dto.getJobName());
//            values.add(dto.getCount());
//        }
//
//        // 4. 将处理好的列表设置到 finalJobOption 对象中
//        finalJobOption.setJobOptions(names);
//        finalJobOption.setJobOptionValues(values);
//
//        // 5. 返回组装好的最终结果
//        return finalJobOption;
//    }

}
