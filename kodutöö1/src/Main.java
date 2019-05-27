/**
 * Created by Jaanus on 7.09.16.
 */
public class Main {
    public static void main(String[] args) {
        StudentOOP s1 = new StudentOOP("Toomas");
        s1.addBirthYear(1997);
        StudentOOP s2 = new StudentOOP("Mari");
        s2.addBirthYear(1996);
        StudentOOP s3 = new StudentOOP("Paul");
        s3.addBirthYear(2014);
        /*
        * "Toomas sündis 2014
          Mari sündis 2014
          Paul sündis  2014"
        * on tulemus alloleval prindil, kui sünniaasta on static.
        */
        System.out.println("Toomas sündis " + s1.getBirthYear() +
                "\nMari sündis " + s2.getBirthYear() +
                "\nPaul sündis " + s3.getBirthYear());
        StudentOOP s4 = new StudentOOP("Liis", 1999);
        StudentOOP s5 = new StudentOOP("Kalle", 2);
    }
}
