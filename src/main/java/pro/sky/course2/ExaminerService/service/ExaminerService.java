package pro.sky.course2.ExaminerService.service;

import pro.sky.course2.ExaminerService.domain.Question;

import java.util.Collection;
import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}
