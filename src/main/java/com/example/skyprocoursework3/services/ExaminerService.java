package com.example.skyprocoursework3.services;

import com.example.skyprocoursework3.models.Task;

import java.util.Collection;

public interface ExaminerService {

    Collection<Task> getTasks(int amount);
}
