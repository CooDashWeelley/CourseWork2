package pro.sky.course2.ExaminerService.service;

import pro.sky.course2.ExaminerService.domain.Question;

import java.util.Collection;

public interface QuestionService {
    void add (String question, String answer);
    void add (Question question);
    void remove(String question);
    Collection<Question> getAll();
    Question getRandomQuestion();

}
