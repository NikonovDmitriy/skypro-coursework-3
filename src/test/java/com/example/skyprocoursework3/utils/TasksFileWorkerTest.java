package com.example.skyprocoursework3.utils;

import com.example.skyprocoursework3.models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TasksFileWorkerTest {

    private TasksFileWorker fileWorker;
    private List<Task> actual;

    @BeforeEach
    public void setUp() {
        fileWorker = new TasksFileWorker();
        try (var ois = new ObjectInputStream(new FileInputStream(TaskType.JAVA.getFile()))) {
            actual = (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            actual = new ArrayList<>();
        }
    }

    @Test
    public void shouldReturnListOfTasksOrEmptyListIfFileNotExist() {
        List<Task> expected = fileWorker.getTasksFromFile(TaskType.JAVA);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueIfFileSuccessRefreshed() {
        assertTrue(fileWorker.refreshTasksFile(TaskType.JAVA, actual));
    }
}
