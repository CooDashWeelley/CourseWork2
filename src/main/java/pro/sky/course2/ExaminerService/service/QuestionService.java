package pro.sky.course2.ExaminerService.service;

import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.repository.QuestionRepositoryInterface;

import java.util.Collection;
import java.util.Random;

public abstract class QuestionService implements QuestionServiceInterface {
    QuestionRepositoryInterface questionRepository;
    Random random = new Random();

    public QuestionService(QuestionRepositoryInterface questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void add(String question, String answer) {
        questionRepository.add(question, answer);
    }

    @Override
    public void add(Question question) {
        questionRepository.add(question);
    }

    @Override
    public void remove(String question) {
        questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    public Question getRandomQuestion() {
        return questionRepository.get(random.nextInt(0, questionRepository.getAll().size()));
    }
}
