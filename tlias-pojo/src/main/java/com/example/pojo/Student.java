package com.example.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Data
public class Student {
    private Integer id;
    private String name;
    private String no;
    private Integer gender;
    private String phone;
    private String idCard;
    private Integer isCollege;
    private String address;
    private Integer degree;
    private Date graduationDate;
    private Integer clazzId;
    private Integer violationCount;
    private Integer violationScore;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private String clazzName;
}
