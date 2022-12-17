package com.example.skyprocoursework3.services.task.math;

import com.example.skyprocoursework3.models.Task;
import com.example.skyprocoursework3.repositories.MathTasksRepository;
import com.example.skyprocoursework3.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MathTaskService implements TaskService {

    private final MathTasksRepository repository;

    @Autowired
    public MathTaskService(MathTasksRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task add(String question, String answer) {
        return add(new Task(question, answer));
    }

    @Override
    public Task add(Task task) {
        return repository.add(task);
    }

    @Override
    public Task remove(String question, String answer) {
        return remove(new Task(question, answer));
    }

    @Override
    public Task remove(Task task) {
        return repository.remove(task);
    }

    @Override
    public Collection<Task> getAll() {
        return repository.getAll();
    }

    @Override
    public Task getRandomTask() {
        return repository.getRandomTask();
    }
}
