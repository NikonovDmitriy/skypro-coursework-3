package com.example.skyprocoursework3.services.examiner;

import com.example.skyprocoursework3.models.Task;
import com.example.skyprocoursework3.services.ExaminerService;
import com.example.skyprocoursework3.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final TaskService javaTaskService;
    private final TaskService mathTaskService;
    private final ExaminerServiceUtil utils;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaTaskService") TaskService javaTaskService,
                               @Qualifier("mathTaskService") TaskService mathTaskService,
                               ExaminerServiceUtil utils) {
        this.javaTaskService = javaTaskService;
        this.mathTaskService = mathTaskService;
        this.utils = utils;
    }

    @Override
    public Collection<Task> getTasks(int amount) {
        int questionCount = javaTaskService.getAll().size() + mathTaskService.getAll().size();
        utils.checkForAmountLessWhenTasksCount(questionCount, amount);

        Set<Task> tasks = new HashSet<>(amount);
        Random r = new Random();
        while (tasks.size() < amount) {
            switch (r.nextInt(2)) {
                case 0:
                    tasks.add(javaTaskService.getRandomTask());
                    break;
                case 1:
                    tasks.add(mathTaskService.getRandomTask());
                    break;
                default:
                    break;
            }
        }

        return tasks;
    }
}
