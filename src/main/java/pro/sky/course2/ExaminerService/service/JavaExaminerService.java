package pro.sky.course2.ExaminerService.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.exception.IllegalNumberOfQuestionException;

import java.util.ArrayList;
import java.util.List;

@Service
public class JavaExaminerService implements ExaminerService {
    private JavaQuestionService service;

    public JavaExaminerService(JavaQuestionService service) {
        this.service = service;

    }

    @Override
    public List<Question> getQuestions(int amount) {
        if (amount > service.getAll().size()) {
            throw new IllegalNumberOfQuestionException("Запрошено больше вопросов, чем есть в списке");
        }
        List<Question> examQuestions = new ArrayList<>();

        for (int i = 0; examQuestions.size() < amount; i++) {
            Question question = service.getRandomQuestion();
            if (!examQuestions.contains(question)) {
                examQuestions.add(question);
            }
        }
        return examQuestions;
    }
}
