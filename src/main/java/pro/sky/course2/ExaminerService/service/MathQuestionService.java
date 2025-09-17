package pro.sky.course2.ExaminerService.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.ExaminerService.repository.MathQuestionRepository;

@Service
public class MathQuestionService extends QuestionService {
    public MathQuestionService(MathQuestionRepository repository) {
        super(repository);
    }
}
