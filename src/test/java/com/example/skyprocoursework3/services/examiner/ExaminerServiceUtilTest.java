package com.example.skyprocoursework3.services.examiner;

import com.example.skyprocoursework3.exceptions.MoreTaskRequestedThanExistException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExaminerServiceUtilTest {

    private final ExaminerServiceUtil utils = new ExaminerServiceUtil();

    @Test
    public void shouldThrowMoreTaskRequestedWhenExistExceptionIfAmountMoreWhenQuestionCount() {
        assertThrows(MoreTaskRequestedThanExistException.class,
                () -> utils.checkForAmountLessWhenTasksCount(3, 4));
    }
}