package pro.sky.course2.ExaminerService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.exception.IllegalNumberOfQuestionException;
import pro.sky.course2.ExaminerService.service.JavaExaminerService;
import pro.sky.course2.ExaminerService.service.JavaQuestionService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class JavaExaminerServiceTest {
    List<Question> testQuestions;

    @Mock
    JavaQuestionService questionService;

    @InjectMocks
    JavaExaminerService examService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testQuestions = List.of(
                new Question("testQuestion1", "testAnswer1"),
                new Question("testQuestion2", "testAnswer2"),
                new Question("testQuestion3", "testAnswer3")
        );
        Mockito.when(questionService.getAll()).thenReturn(testQuestions);
    }

    @Test
    public void testGetQuestions_whenValidAmount_thenGetListOfQuestion() {
        Mockito.when(questionService.getRandomQuestion()).thenReturn(
                testQuestions.get(0),
                testQuestions.get(1)
        );

        List<Question> result = examService.getQuestions(2);

        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.containsAll(testQuestions.subList(0, 2)));
    }

    @Test
    public void testGetQuestions_whenAmountMoreTotal_thenThrowIllegalNumberOfQuestionException() {
        Assertions.assertThrows(IllegalNumberOfQuestionException.class, () -> examService.getQuestions(4));
    }

    @Test
    public void testGetQuestions_whenAmountIsZero_thenGetEmptyList() {
        List<Question> result = examService.getQuestions(0);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testGetQuestion_whenAmountLessZero_thenGetEmptyList() {
        List<Question> result = examService.getQuestions(-1);

        Assertions.assertTrue(result.isEmpty());
    }
}
