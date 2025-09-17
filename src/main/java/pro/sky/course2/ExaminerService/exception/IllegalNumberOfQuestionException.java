package pro.sky.course2.ExaminerService.exception;

public class IllegalNumberOfQuestionException extends RuntimeException {
    public IllegalNumberOfQuestionException(String message) {
        super(message);
    }
}
