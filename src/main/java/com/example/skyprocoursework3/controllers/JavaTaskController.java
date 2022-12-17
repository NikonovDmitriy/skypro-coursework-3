package com.example.skyprocoursework3.controllers;

import com.example.skyprocoursework3.models.Task;
import com.example.skyprocoursework3.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaTaskController {

    private final TaskService taskService;

    @Autowired
    public JavaTaskController(@Qualifier("javaTaskService") TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public Collection<Task> allTasks() {
        return taskService.getAll();
    }

    @GetMapping("/add")
    public com.example.skyprocoursework3.models.Task addTask(@RequestParam(value = "question") String question,
                                                             @RequestParam(value = "answer") String answer) {
        return taskService.add(question, answer);
    }

    @GetMapping("/remove")
    public com.example.skyprocoursework3.models.Task removeTask(@RequestParam(value = "question") String question,
                                                                @RequestParam(value = "answer") String answer) {
        return taskService.remove(question, answer);
    }
}