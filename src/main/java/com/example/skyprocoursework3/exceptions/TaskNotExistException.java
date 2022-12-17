package com.example.skyprocoursework3.exceptions;

public class TaskNotExistException extends RuntimeException{

    public TaskNotExistException() {
        super("This task is not exist!");
    }
}
