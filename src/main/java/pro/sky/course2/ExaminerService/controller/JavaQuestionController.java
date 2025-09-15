package pro.sky.course2.ExaminerService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.service.ExaminerServiceImpl;
import pro.sky.course2.ExaminerService.service.JavaQuestionService;

import java.util.Collection;

@RequestMapping("/exam/java")
@RestController
public class JavaQuestionController {
    private JavaQuestionService javaQuestionService;
    private ExaminerServiceImpl examinerServiceImpl;

    public JavaQuestionController(
            JavaQuestionService javaQuestionService,
            ExaminerServiceImpl examinerServiceImpl
    ) {
        this.javaQuestionService = javaQuestionService;
        this.examinerServiceImpl = examinerServiceImpl;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/add")
    public void add(@RequestParam(name = "question", required = true) String question,
                    @RequestParam(name = "answer", required = true) String answer) {
        javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public void remove(@RequestParam("question") String question) {
        javaQuestionService.remove(question);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> exam(@RequestParam("amount") int amount) {
        return examinerServiceImpl.getQuestions(amount);
    }
}
