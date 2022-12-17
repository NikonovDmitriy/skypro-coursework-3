package com.example.skyprocoursework3.repositories;

import com.example.skyprocoursework3.models.Task;
import com.example.skyprocoursework3.utils.TaskType;
import com.example.skyprocoursework3.utils.TasksFileWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class MathTasksRepository {


    private final List<Task> tasks;
    private final TasksRepositoriesUtil util;
    private final TasksFileWorker fileWorker;

    @Autowired
    public MathTasksRepository(TasksRepositoriesUtil util, TasksFileWorker fileWorker) {
        this.util = util;
        this.fileWorker = fileWorker;
        tasks = this.fileWorker.getTasksFromFile(TaskType.MATH);
    }

    public Task add(Task task) {
        util.checkExistenceOfTask(tasks, task, false);
        tasks.add(task);
        fileWorker.refreshTasksFile(TaskType.MATH, tasks);
        return task;
    }

    public Task remove(Task task) {
        util.checkExistenceOfTask(tasks, task, true);
        tasks.remove(task);
        fileWorker.refreshTasksFile(TaskType.MATH, tasks);
        return task;
    }

    public Collection<Task> getAll() {
        return tasks;
    }

    public Task getRandomTask() {
        return tasks.get(util.getRandomTaskIndex(tasks));
    }
}
