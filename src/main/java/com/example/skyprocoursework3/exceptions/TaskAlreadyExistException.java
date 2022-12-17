package com.example.skyprocoursework3.exceptions;

public class TaskAlreadyExistException extends RuntimeException{

    public TaskAlreadyExistException() {
        super("This task already exist!");
    }
}
