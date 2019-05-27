package student;

/**
 * Created by Jaanus on 19.12.16.
 */
public class Student {

    private int grade;

    public Student(int grade) {
        this.grade = grade;
    }

    public static boolean isPassingStatic(Student s) {
        return s.getGrade() > 2;
    }

    public boolean isPassing() {
        return grade > 2;
    }

    public int getGrade() {
        return grade;
    }
}
