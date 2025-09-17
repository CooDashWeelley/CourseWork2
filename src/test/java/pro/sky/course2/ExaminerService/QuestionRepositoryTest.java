package pro.sky.course2.ExaminerService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.exception.IncorrectValueException;
import pro.sky.course2.ExaminerService.repository.QuestionRepository;

@ExtendWith(MockitoExtension.class)
public class QuestionRepositoryTest {
    private QuestionRepository repository = new QuestionRepository() {
    };

    @Test
    public void testAdd_whenValidValues_thenQuestionAdded() {
        String question = "question";
        String answer = "answer";
        Question question1 = new Question(question, answer);
        repository.add(question, answer);

        Assertions.assertEquals(question1, repository.get(0));
        Assertions.assertEquals(1, repository.getAll().size());
    }

    @Test
    public void testAdd_whenInvalidValues_thenThrowException() {
        Assertions.assertThrows(IncorrectValueException.class, () -> repository.add(null, null));
    }

    @Test
    public  void testAdd_whenQuestionEqualsAnswer_thenThrowException() {
        Assertions.assertThrows(IncorrectValueException.class, () -> repository.add("test", "test"));
    }
}
