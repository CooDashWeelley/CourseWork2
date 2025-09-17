package pro.sky.course2.ExaminerService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.exception.IncorrectValueException;
import pro.sky.course2.ExaminerService.service.JavaQuestionService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    private List<Question> mockList;
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }
//    getAll tested in other methods

    @Test
    public void testAdd_whenQuestionEqualsAnswer_thenThrowException() {
        String test = "test";

        Assertions.assertThrows(IncorrectValueException.class, () -> javaQuestionService.add(test, test));
    }

    @Test
    public void testAdd_whenValidValues_thenQuestionAdded() {
        String question = "testQuestion";
        String answer = "testAnswer";

        javaQuestionService.add(question, answer);

        Assertions.assertEquals(1, javaQuestionService.getAll().size());
        Assertions.assertEquals(question, javaQuestionService.getAll().get(0).getQuestion());
        Assertions.assertEquals(answer, javaQuestionService.getAll().get(0).getAnswer());
    }

    @Test
    public void testAdd_whenInvalidValues_thenThrowException() {
        String question = null;
        String answer = "testAnswer";

        Assertions.assertThrows(IncorrectValueException.class, () -> javaQuestionService.add(question, answer));
    }

    @Test
    public void testRemove_whenValidValue_thenQuestionRemoved() {
        javaQuestionService.add(new Question("question1", "answer1"));
        javaQuestionService.add(new Question("question2", "answer2"));
        javaQuestionService.add(new Question("question3", "answer3"));

        javaQuestionService.remove("question1");

        Assertions.assertEquals(2, javaQuestionService.getAll().size());
        Assertions.assertFalse(javaQuestionService.getAll().stream()
                .anyMatch(e -> e.getQuestion().equals("question1"))
        );
    }

    @Test
    public void testRemove_whenInvalidValue_thenNothingRemoved() {
        javaQuestionService.add(new Question("question1", "answer1"));
        javaQuestionService.add(new Question("question2", "answer2"));
        javaQuestionService.add(new Question("question3", "answer3"));

        javaQuestionService.remove("test");

        Assertions.assertEquals(3, javaQuestionService.getAll().size());
    }

    @Test
    public void testRemove_whenEmptyList_thenNothingRemoved() {

        javaQuestionService.remove("test");

        Assertions.assertTrue(javaQuestionService.getAll().isEmpty());
    }

    @Test
    public void testGetRandomQuestion_whenValidValue_thenReturnQuestion() {
        javaQuestionService.add(new Question("question1", "answer1"));
        javaQuestionService.add(new Question("question2", "answer2"));
        javaQuestionService.add(new Question("question3", "answer3"));

        Question question = javaQuestionService.getRandomQuestion();

        Assertions.assertTrue(javaQuestionService.getAll().contains(question));

    }
}
