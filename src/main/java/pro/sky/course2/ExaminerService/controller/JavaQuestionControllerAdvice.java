package pro.sky.course2.ExaminerService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.sky.course2.ExaminerService.error.QuestionError;
import pro.sky.course2.ExaminerService.exception.IllegalNumberOfQuestionException;
import pro.sky.course2.ExaminerService.exception.IncorrectValueException;

@ControllerAdvice
public class JavaQuestionControllerAdvice {
    @ExceptionHandler(IllegalNumberOfQuestionException.class)
    public ResponseEntity<QuestionError> handleIllegalNumberOfQuestionException(IllegalNumberOfQuestionException e) {
        QuestionError questionError = new QuestionError("BAD_REQUEST", "illegal  number of  question");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionError);
    }

    @ExceptionHandler(IncorrectValueException.class)
    public ResponseEntity<QuestionError> handleIncorrectValueException(IncorrectValueException e)  {
        QuestionError questionError =  new QuestionError("BAD_REQUEST", "Incorrect value");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(questionError);
    }
}
