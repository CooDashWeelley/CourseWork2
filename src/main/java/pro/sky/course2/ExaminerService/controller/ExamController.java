package pro.sky.course2.ExaminerService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.service.JavaExaminerService;
import pro.sky.course2.ExaminerService.service.MathExaminerService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private JavaExaminerService javaExaminerService;
    private MathExaminerService mathExaminerService;

    public ExamController(JavaExaminerService javaExaminerService, MathExaminerService mathExaminerService) {
        this.javaExaminerService = javaExaminerService;
        this.mathExaminerService = mathExaminerService;
    }

    @GetMapping("/java/get/{amount}")
    public List<Question> examJava(@PathVariable("amount") int amount) {
        return javaExaminerService.getQuestions(amount);
    }
    @GetMapping("/math/get/{amount}")
    public List<Question> examMath(@PathVariable("amount") int amount) {
        return mathExaminerService.getQuestions(amount);
    }

}
