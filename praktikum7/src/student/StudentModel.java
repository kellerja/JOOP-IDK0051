package student;

public interface StudentModel {
    // sets some arbitrary value for grade
    public void setGrade(int grade);
    // return the value of grade
    public int getGrade();
    // return name of the student
    public String getName();
    // return age of the student
    public int getAge();
    // return how many credit points s/he has earned
    public int getEarnedCreditPoints();
    // return number of credit points required to graduate
    public int getNominalCreditPoints();
}
