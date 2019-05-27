import grinder.Grinder;
import grinder.GrinderNotCleanException;

/**
 * Created by Jaanus on 5.10.16.
 */
public class Main {
    private static Grinder grinder;

    public static void main(String[] args) {
        grinder = new Grinder();
        try {
            grindNumberOfTimes(4);
        } catch(GrinderNotCleanException e) {
            System.out.println("Clean the machine");
        }

        try {
            grinder.enterEnergySavingMode(61);
        } catch(IllegalArgumentException e) {
            System.out.println("Use value between 0 and 60 (inclusive)");
        }
    }

    private static void grindNumberOfTimes(int grindNumber) {
        for (int grind = 1; grind <= grindNumber; grind++) {
            grinder.grind();
        }
    }
}
