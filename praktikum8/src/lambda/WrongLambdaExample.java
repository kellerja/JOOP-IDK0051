package lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaanus on 9.11.16.
 */
public class WrongLambdaExample {
    public static void main(String[] args) {
        Student student = new Student();
        List<Student> students = new ArrayList<>();
        students.add(student);
        //students.stream().filter(s -> s.getGrade());
        //students.stream().filter((s, m) -> s.getGrade() == 0);
    }
}
