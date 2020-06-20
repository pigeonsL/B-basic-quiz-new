package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserErrorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handle(UserErrorException e) {
        return new ErrorResult(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException e){
        return errorResultResponseEntityBuilder(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }


    public ResponseEntity<ErrorResult> errorResultResponseEntityBuilder(String responseMessage){
        ErrorResult errorResult = new ErrorResult(HttpStatus.BAD_REQUEST.value(), responseMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
