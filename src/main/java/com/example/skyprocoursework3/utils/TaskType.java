package com.example.skyprocoursework3.utils;

import java.io.File;

public enum TaskType {
    JAVA("src/main/java/com/example/skyprocoursework3/files/JavaTasks.bin"),
    MATH("src/main/java/com/example/skyprocoursework3/files/MathTasks.bin");

    private final String path;

    TaskType(String path) {
        this.path = path;
    }

    public File getFile() {
        return new File(path);
    }
}