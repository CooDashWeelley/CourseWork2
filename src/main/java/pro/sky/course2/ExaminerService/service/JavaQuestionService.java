package pro.sky.course2.ExaminerService.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.ExaminerService.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private List<Question> questions;
    private Random random = new Random();

    public JavaQuestionService() {
        this.questions = new ArrayList<>();
    }
    @Override
    public void add(String question, String answer) {
        questions.add(new Question(question, answer));
    }

    @Override
    public void add(Question question) {
        questions.add(question);
    }

    @Override
    public void remove(String question) {
        questions.removeIf(e -> e.getQuestion().equals(question));
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(random.nextInt(0, questions.size() - 1));
    }


}
