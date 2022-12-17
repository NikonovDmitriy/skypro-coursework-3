package com.example.skyprocoursework3.exceptions.handlers;

import com.example.skyprocoursework3.exceptions.TaskAlreadyExistException;
import com.example.skyprocoursework3.exceptions.TaskNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskServiceExceptionHandler {

    @ExceptionHandler(TaskAlreadyExistException.class)
    public ResponseEntity<Object> taskAlreadyExist(TaskAlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TaskNotExistException.class)
    public ResponseEntity<Object> taskNotExist(TaskNotExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
