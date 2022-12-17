package com.example.skyprocoursework3.utils;

import com.example.skyprocoursework3.models.Task;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TasksFileWorker {

    public List<Task> getTasksFromFile(TaskType taskType) {
        try (var ois = new ObjectInputStream(new FileInputStream(taskType.getFile()))) {
            return (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public boolean refreshTasksFile(TaskType taskType, List<Task> tasks) {
        try (var oos = new ObjectOutputStream(new FileOutputStream(taskType.getFile()))) {
            oos.writeObject(tasks);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
