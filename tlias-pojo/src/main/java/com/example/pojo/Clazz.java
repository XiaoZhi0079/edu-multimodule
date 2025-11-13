package com.example.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Data
@Schema(name = "班级",description = "班级的POJO类")
public class Clazz {

@Schema(description = "班级ID", example = "1")
private Integer id;

@Schema(description = "班级名称", example = "Java班")
private String name;

@Schema(description = "班级教室", example = "504")
private String room;

@Schema(description = "开班时间", example = "2004-5-14")
private Date beginDate;

@Schema(description = "结束时间", example = "2104-5-14")
private Date endDate;

@Schema(description = "班主任ID", example = "1")
private Integer masterId;

@Schema(description = "科目", example = "5")
private Integer subject;

@Schema(description = "系统添加时间", example = "2004-5-14")
private LocalDateTime createTime;

@Schema(description = "系统更新时间", example = "2004-5-14")
private LocalDateTime updateTime;

@Schema(description = "班主任名字", example = "里美尤利娅")
private String masterName;

@Schema(description = "班级状态", example = "在读")
private String status;//班级状态 - 未开班 , 在读 , 已结课
}
