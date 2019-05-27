/**
 * Created by Jaanus on 7.09.16.
 */
public class StudentOOP {

    private String name;
    private int points = 0;
    /*
    * Muutes birtYear static muutujaks ja printides välja 3 StudentOOP objekti
    * erinevat sünniaastat on tulemuseks sama sünniaasta, mis oli viimasena sisestatud
    * objekti sünniaasta.
    */
    private int birthYear;

    public StudentOOP(String name) {
        this.name = name;
    }

    public StudentOOP(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public void addPoints(int pointsToAdd) {
        this.points += pointsToAdd;
    }

    public void addBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getPoints() {
        return points;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
