package studentservice;

/**
 * Created by Jaanus on 2.11.16.
 */
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    void processGrades() {
        service.addGrade(3333, 4);
        service.addGrade(3543242, 5);
    }

    public static void main(String[] args) {
        MyLogger logger = new MyLogger();
        new StudentController(new StudentService(logger)).processGrades();
    }
}
