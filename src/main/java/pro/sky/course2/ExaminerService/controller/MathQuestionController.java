package pro.sky.course2.ExaminerService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.service.MathQuestionService;

import java.util.Collection;

@RequestMapping("/exam/math")
@RestController
public class MathQuestionController {
    private MathQuestionService service;

    public MathQuestionController(MathQuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public String add(@RequestParam(name = "question", required = true) String question,
                      @RequestParam(name = "answer", required = true) String answer) {
        service.add(question, answer);
        return "question  added";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("question") String question) {
        service.remove(question);
        return "question removed";
    }

    @GetMapping
    public Collection<Question> getAll() {
        return service.getAll();
    }


}
