package pro.sky.course2.ExaminerService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import pro.sky.course2.ExaminerService.domain.Question;
import pro.sky.course2.ExaminerService.service.ExaminerServiceImpl;
import pro.sky.course2.ExaminerService.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

public class ExaminerServiceImplTest {

    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    public void testGetQuestion() {
        List<Question> testQuestions = List.of(
                new Question("testQuestion1", "testAnswer1"),
                new Question("testQuestion2", "testAnswer2"),
                new Question("testQuestion3", "testAnswer3")
        );
        Mockito.when(questionService.getAll()).thenReturn(testQuestions);

        List<Question> result = examinerService.getQuestions(2);

        Assertions.assertEquals(2, result.size());
    }

}
