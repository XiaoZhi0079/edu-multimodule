package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOption {
    //职位列表
    private List jobList;
    //职位列表数量
    private List dataList;
}
