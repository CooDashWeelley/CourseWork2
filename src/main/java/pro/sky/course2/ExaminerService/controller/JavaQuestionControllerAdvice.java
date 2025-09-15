package pro.sky.course2.ExaminerService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.sky.course2.ExaminerService.exception.IllegalNumberOfQuestionException;

@ControllerAdvice
public class JavaQuestionControllerAdvice {
    @ExceptionHandler(IllegalNumberOfQuestionException.class)
    public void handleIllegalNumberOfQuestionException(IllegalNumberOfQuestionException e) {
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
    }
}
