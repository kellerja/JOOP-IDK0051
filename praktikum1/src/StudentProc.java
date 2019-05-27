import java.util.HashMap;
class StudentProc {
    static HashMap<String, Integer> students = new HashMap<>();
    public static void addStudent (String name) {
        if (name != null) {
        students.put(name, new Integer(0));
        }
    }
    public static void addPoints(String studentName, int pointsToAdd) {
        if (students.containsKey(studentName)) {
            students.put(studentName, new Integer(students.get(studentName).intValue() + pointsToAdd));
        }
    }
    public static int getPoints(String studentName) {
        if (students.containsKey(studentName)) {
            return students.get(studentName).intValue();
        }
        return -1;
    }
}
