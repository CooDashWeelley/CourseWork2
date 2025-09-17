package pro.sky.course2.ExaminerService.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.exception.IncorrectValueException;
import pro.sky.course2.ExaminerService.repository.JavaQuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService extends QuestionService {
    public JavaQuestionService(JavaQuestionRepository repository) {
        super(repository);
    }
}
