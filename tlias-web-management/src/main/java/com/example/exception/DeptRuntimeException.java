package com.example.exception;

import io.swagger.v3.oas.annotations.Hidden;

//@Hidden
public class DeptRuntimeException extends RuntimeException{
    public DeptRuntimeException(String message) {
        super(message);
    }
}
