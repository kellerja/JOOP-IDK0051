package student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Jaanus on 2.11.16.
 */
public class StudentProcessor {
    void processStudents() {
        List<Student> students = IntStream
                .range(55, 66)
                .mapToObj(num -> new Student(num))
                .collect(Collectors.toList());
        students.forEach(s -> s.setGrade(5));
        long count = students.stream()
                .filter(s -> s.getEarnedCreditPoints() >= 60)
                .count();
        List<Student> studentsWithOver60EAP = students.stream()
                .filter(s -> s.getEarnedCreditPoints() >= 60)
                .collect(Collectors.toList());
        studentsWithOver60EAP.forEach(s -> System.out.println(s.getEarnedCreditPoints()));
    }

    public static void main(String[] args) {
        new StudentProcessor().processStudents();
    }
}
