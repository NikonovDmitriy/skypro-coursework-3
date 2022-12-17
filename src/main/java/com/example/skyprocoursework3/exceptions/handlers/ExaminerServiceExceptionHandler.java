package com.example.skyprocoursework3.exceptions.handlers;

import com.example.skyprocoursework3.exceptions.MoreTaskRequestedThanExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExaminerServiceExceptionHandler {

    @ExceptionHandler(MoreTaskRequestedThanExistException.class)
    public ResponseEntity<Object> moreTaskRequestedThanExist(MoreTaskRequestedThanExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
