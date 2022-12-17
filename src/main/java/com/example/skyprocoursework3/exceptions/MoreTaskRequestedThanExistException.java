package com.example.skyprocoursework3.exceptions;

public class MoreTaskRequestedThanExistException extends RuntimeException{

    public MoreTaskRequestedThanExistException() {
        super("More unique task requested than exist!");
    }
}
