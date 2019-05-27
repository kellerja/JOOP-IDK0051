import grinder.FlavourNotAvailableException;
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
        } catch (GrinderNotCleanException e) {
            cleanGrinder();
        }

        try {
            grinder.enterEnergySavingMode(61);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            grinder.makeFlavoredCoffee("mud");
        } catch (FlavourNotAvailableException e) {
            e.printStackTrace();
        } catch (GrinderNotCleanException e) {
            cleanGrinder();
        }
    }

    private static void cleanGrinder() {
        System.out.println("Machine not clean. Cleaning...");
        grinder.clean();
        System.out.println("Machine is now clean.");
    }

    private static void grindNumberOfTimes(int grindNumber) {
        for (int grind = 1; grind <= grindNumber; grind++) {
            grinder.grind();
        }
    }
}
