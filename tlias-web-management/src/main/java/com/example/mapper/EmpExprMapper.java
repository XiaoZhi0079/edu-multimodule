package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//员工工作经历

@Mapper
public interface EmpExprMapper {
    void addEmpExprsBatch(List<EmpExpr> empExprsList);


    void deleteByempid(List<Integer> empids);
}
