package com.example.exception;

import io.swagger.v3.oas.annotations.Hidden;

//@Hidden
public class ClazzRuntimeException extends RuntimeException{
    public ClazzRuntimeException(String message)
    {
        super(message);
    }
}
