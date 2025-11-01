package com.example.exception;


import com.aliyun.oss.ServiceException;
import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHander {
    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("服务器异常", e);
        return Result.error("出错啦");
    }
    @ExceptionHandler
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("服务器异常", e);
        String message = e.getMessage();
        return Result.error(message);
    }
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("服务器异常", e);
        String message = e.getMessage();
        return Result.error(message);
    }
    @ExceptionHandler
    public Result handleDeptRuntimeException(DeptRuntimeException e) {
        log.error("服务器异常", e);
        String message = e.getMessage();
        return Result.error(message);
    }
    @ExceptionHandler
    public Result handleClazzRuntimeException(ClazzRuntimeException e) {
        log.error("服务器异常", e);
        String message = e.getMessage();
        return Result.error(message);
    }
}
