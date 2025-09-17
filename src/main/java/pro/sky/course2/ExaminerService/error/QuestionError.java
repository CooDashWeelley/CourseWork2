package pro.sky.course2.ExaminerService.error;

import java.util.Objects;

public class QuestionError {
    private String code;
    private String message;

    public QuestionError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuestionError that = (QuestionError) o;
        return Objects.equals(code, that.code) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "QuestionError{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
