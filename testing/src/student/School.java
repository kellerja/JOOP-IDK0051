package student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaanus on 19.12.16.
 */
public class School {

    private void open() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(4));
        students.add(new Student(2));
        students.add(new Student(3));
        System.out.println(students.stream().filter(s -> s.isPassing()).count());
        System.out.println(students.stream().filter(s -> Student.isPassingStatic(s)).count());
        System.out.println(students.stream().filter(Student::isPassingStatic).count());
        System.out.println(students.stream().filter(Student::isPassing).count());
    }

    public static void main(String[] args) {
        new School().open();
    }
}
