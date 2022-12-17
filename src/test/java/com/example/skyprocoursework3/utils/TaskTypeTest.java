package com.example.skyprocoursework3.utils;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTypeTest {

    @Test
    public void shouldReturnJavaTasksFile() {
        final File actual = new File("src/main/java/ru/ezuykow/examapp/files/JavaTasks.bin");
        final File expected = TaskType.JAVA.getFile();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMathTasksFile() {
        final File actual = new File("src/main/java/ru/ezuykow/examapp/files/MathTasks.bin");
        final File expected = TaskType.MATH.getFile();
        assertEquals(expected, actual);
    }
}
