package com.example.skyprocoursework3.repositories;

import com.example.skyprocoursework3.exceptions.TaskAlreadyExistException;
import com.example.skyprocoursework3.exceptions.TaskNotExistException;
import com.example.skyprocoursework3.models.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class TasksRepositoriesUtil {

    public void checkExistenceOfTask(List<Task> tasks, Task task, Boolean mustExist) {
        final boolean isExist = tasks.contains(task);
        if (isExist && !mustExist) {
            throw new TaskAlreadyExistException();
        }
        if (mustExist && !isExist) {
            throw new TaskNotExistException();
        }
    }

    public int getRandomTaskIndex(List<Task> tasks) {
        Random r = new Random();
        return r.nextInt(tasks.size());
    }
}
