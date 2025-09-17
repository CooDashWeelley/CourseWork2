package pro.sky.course2.ExaminerService.repository;

import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.exception.IncorrectValueException;

import java.util.ArrayList;
import java.util.List;

public abstract class QuestionRepository implements QuestionRepositoryInterface{
    private List<Question> questions;

    public QuestionRepository() {
        this.questions = new ArrayList<>();
    }

    public void add(String question, String answer) {
        if (question == null || answer == null || question.equals(answer)) {
            throw new IncorrectValueException("no values specified");
        }
        questions.add(new Question(question, answer));
    }

    public void add(Question question) {
        if (question == null) {
            throw new IncorrectValueException("no values specified");
        }
        questions.add(question);
    }

    public void remove(String question) {
        questions.removeIf(e -> e.getQuestion().equals(question));
    }

    public Question get(int index) {
        return questions.get(index);
    }

    public List<Question> getAll() {
        return questions;
    }
}
