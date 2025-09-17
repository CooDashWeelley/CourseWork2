package pro.sky.course2.ExaminerService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.service.JavaQuestionService;

import java.util.Collection;

@RequestMapping("/exam/java")
@RestController
public class JavaQuestionController {
    private JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public String add(@RequestParam(name = "question", required = true) String question,
                      @RequestParam(name = "answer", required = true) String answer) {
        javaQuestionService.add(question, answer);
        return "question  added";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("question") String question) {
        javaQuestionService.remove(question);
        return "question removed";
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }
}
