package studentservice;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by Jaanus on 2.11.16.
 */
public class StudentServiceTest {
    private MyLogger logger;
    private StudentService service;

    @Before
    public void setUp() {
        logger = mock(MyLogger.class);
        service = new StudentService(logger);
    }

    @Test
    public void testThatCorrectLineLogged() {
        service.addGrade(34323, 5);
        verify(logger).log("Grade set to: 5");
    }
}
