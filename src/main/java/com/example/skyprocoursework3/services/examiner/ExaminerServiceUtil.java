package com.example.skyprocoursework3.services.examiner;

import com.example.skyprocoursework3.exceptions.MoreTaskRequestedThanExistException;
import org.springframework.stereotype.Component;

@Component
public class ExaminerServiceUtil {

    public void checkForAmountLessWhenTasksCount(int questionCount, int amount) {
        if (questionCount < amount) {
            throw new MoreTaskRequestedThanExistException();
        }
    }
}
