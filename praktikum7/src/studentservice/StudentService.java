package studentservice;

/**
 * Created by Jaanus on 2.11.16.
 */
public class StudentService {

    private MyLogger logger;

    public StudentService(MyLogger logger) {
        this.logger = logger;
    }

    public void addGrade(int studentCode, int grade) {
        logger.log("Grade set to: " + grade);
    }
}
