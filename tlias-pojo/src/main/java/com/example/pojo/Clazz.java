package com.example.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Data
public class Clazz {
private Integer id;
private String name;
private String room;
private Date beginDate;
private Date endDate;
private Integer masterId;
private Integer subject;
private LocalDateTime createTime;
private LocalDateTime updateTime;


private String masterName;
private String status;//班级状态 - 未开班 , 在读 , 已结课
}
