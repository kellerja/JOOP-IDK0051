package student;

/**
 * Created by Jaanus on 14.09.16.
 */
public class StudentStatusCheck implements StudentStatusCheckInterface {
    private String[] acceptedSchools = new String[]{"MHG", "KARDLA", "NOO", "REAAL"};

    @Override
    public boolean isStudent(String identificationCode, String schoolIdentifier) {
        char identificationCodeFirstDigit = identificationCode.charAt(0);
        return (arrayContains(acceptedSchools, schoolIdentifier) &&
                (identificationCodeFirstDigit == '5'|| identificationCodeFirstDigit == '6'));
    }

    private boolean arrayContains(String[] array, String item) {
        if (array == null) {
            return false;
        }
        for (String element: array) {
            if (element == null && item == null) {
                return true;
            }
            if (element != null && element.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
