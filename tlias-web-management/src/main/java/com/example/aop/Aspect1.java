package com.example.aop;

import com.example.mapper.OperateLogMapper;
import com.example.pojo.OperateLog;
import com.example.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;


@Slf4j
@Component
@Aspect
public class Aspect1 {

    @Autowired
    private OperateLogMapper operateLogMapper;
    @Around("@annotation(com.example.anno.LogOpeartion)")
    public Object insertLogOpeartion(ProceedingJoinPoint pjp) throws Throwable {
        Long starttime=System.currentTimeMillis();

        //执行目标方法
        Object result=pjp.proceed();
        Long endtime=System.currentTimeMillis();
        //计算花费时间
        Long costtime=endtime-starttime;

        OperateLog Oplog=new OperateLog();
        //获取当前登录用户
        Oplog.setOperateEmpId(getID());
        //获取当前时间
        Oplog.setOperateTime(LocalDateTime.now());
        //获取类名
        Oplog.setCostTime(costtime);
        //获取方法名
        Oplog.setClassName(pjp.getTarget().getClass().getName());
        //获取方法参数
        Oplog.setMethodName(pjp.getSignature().getName());
        //获取方法参数
        Oplog.setMethodParams(Arrays.toString(pjp.getArgs()));
        //获取返回值
        Oplog.setReturnValue(result!=null ? result.toString():"无返回值");

        //保存日志
        operateLogMapper.insert(Oplog);
        log.info("线程信息{}",CurrentHolder.getCurrentId());

        return result;
    }
    private Integer getID(){
        return CurrentHolder.getCurrentId();
    }
}
