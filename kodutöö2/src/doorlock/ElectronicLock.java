package doorlock;

import student.StudentStatusCheck;
import student.StudentStatusCheckInterface;

/**
 * Created by Jaanus on 16.09.16.
 */
public class ElectronicLock {
    private String schoolIdentification;
    private StudentStatusCheckInterface validator;

    public ElectronicLock(String school) {
        this.schoolIdentification = school;
        this.validator = new StudentStatusCheck();
    }

    public void openDoor(String studentID) {
        String message = "õpilasele " + studentID + " koolis " + schoolIdentification;
        if (validator.isStudent(studentID, schoolIdentification)) {
            System.out.println("Sisenemine lubatud " + message);
        } else {
            System.out.println("Sisenemine keelatud " + message);
        }
    }
}
