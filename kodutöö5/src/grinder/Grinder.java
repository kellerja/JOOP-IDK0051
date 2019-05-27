package grinder;

import java.time.LocalTime;

/**
 * Created by Jaanus on 5.10.16.
 */
public class Grinder {
    private static final double GRANULARITY = 1.0;
    private long grindCount = 0;
    private boolean energySavingMode;
    private CoffeeFlavourAdder coffeeFlavourComponent;

    public Grinder() {
        coffeeFlavourComponent = new CoffeeFlavourAdder();
    }

    public static Grinder getInstance(LocalTime currentTime) {
        if (isEspressoTime(currentTime)) {
            return new EspressoGrinder();
        }
        return new Grinder();
    }

    public double grind() {
        if (grindCount >= 3) {
            throw new GrinderNotCleanException("Clean now!");
        }
        if (isInEnergySavingMode()) {
            exitEnergySavingMode();
        }
        grindCount++;
        return GRANULARITY;
    }

    private static boolean isEspressoTime(LocalTime currentTime) {
        final LocalTime timeToStartMakingEspresso = LocalTime.of(6, 0);
        final LocalTime timeToStopMakingEspresso = LocalTime.of(11, 0);
        return currentTime.isAfter(timeToStartMakingEspresso) && currentTime.isBefore(timeToStopMakingEspresso);
    }

    public long getGrindCount() {
        return grindCount;
    }

    public void clean() {
        grindCount = 0;
    }

    public void enterEnergySavingMode(int durationInMinutes) {
        if (durationInMinutes < 0 || durationInMinutes > 60) {
            throw new IllegalArgumentException("Enter a value between 0-60");
        }
        energySavingMode = true;
    }

    public boolean isInEnergySavingMode() {
        return energySavingMode;
    }

    public void exitEnergySavingMode() {
        energySavingMode = false;
    }

    public void makeFlavoredCoffee(String flavor) {
        coffeeFlavourComponent.addFlavor(flavor);
        grind();
    }
}
