package pro.sky.course2.ExaminerService.exception;

public class IncorrectValueException extends RuntimeException {
    public IncorrectValueException(String message) {
        super(message);
    }
}
