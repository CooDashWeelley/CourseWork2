package pro.sky.course2.ExaminerService.service;

import pro.sky.course2.ExaminerService.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
