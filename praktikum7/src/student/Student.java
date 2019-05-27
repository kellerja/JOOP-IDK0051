package student;

/**
 * Created by Jaanus on 2.11.16.
 */
public class Student implements StudentModel {
    private int grade;
    private String name;
    private int age;
    private int earnedCreditPoints;
    private int nominalCreditPoints;

    public Student(String name, int age, int earnedCreditPoints, int nominalCreditPoints) {
        this.name = name;
        this.age = age;
        this.earnedCreditPoints = earnedCreditPoints;
        this.nominalCreditPoints = nominalCreditPoints;
    }

    public Student(int earnedCreditPoints) {
        this.earnedCreditPoints = earnedCreditPoints;
    }

    @Override
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int getGrade() {
        return grade;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getEarnedCreditPoints() {
        return earnedCreditPoints;
    }

    @Override
    public int getNominalCreditPoints() {
        return nominalCreditPoints;
    }
}
