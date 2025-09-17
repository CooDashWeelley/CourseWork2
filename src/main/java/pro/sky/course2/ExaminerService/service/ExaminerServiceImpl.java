package pro.sky.course2.ExaminerService.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.exception.IllegalNumberOfQuestionException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new IllegalNumberOfQuestionException("Запрошено больше вопросов, чем есть в списке");
        }
        List<Question> examQuestions = new ArrayList<>();

        for (int i = 0; examQuestions.size() < amount; i++) {
            Question question = questionService.getRandomQuestion();
            if (!examQuestions.contains(question)) {
                examQuestions.add(question);
            }
        }
        return examQuestions;
    }
}
