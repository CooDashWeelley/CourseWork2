package pro.sky.course2.ExaminerService.repository;

import pro.sky.course2.ExaminerService.domain.Question;

import java.util.Collection;

public interface QuestionRepositoryInterface {
    void add(String question, String answer);

    void add(Question question);

    void remove(String question);

    Question get(int amount);

    Collection<Question> getAll();
}
