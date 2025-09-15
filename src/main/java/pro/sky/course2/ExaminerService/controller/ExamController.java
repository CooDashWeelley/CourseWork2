package pro.sky.course2.ExaminerService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.service.ExaminerServiceImpl;

import java.util.Collection;


@RestController
public class ExamController {
    private ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> exam(@PathVariable("amount") int amount) {
        return examinerServiceImpl.getQuestions(amount);
    }

}
