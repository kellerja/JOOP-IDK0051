package grinder;

/**
 * Created by Jaanus on 5.10.16.
 */
public class Grinder {
    private static final double GRANULARITY = 1.0;
    private long grindCount = 0;
    private boolean energySavingMode;

    public double grind() {
        if (grindCount >= 3) {
            throw new GrinderNotCleanException("Puhasta kohe!");
        }
        grindCount++;
        return GRANULARITY;
    }

    public long getGrindCount() {
        return grindCount;
    }

    public void clean() {
        grindCount = 0;
    }

    public void enterEnergySavingMode(int durationInMinutes) {
        if (durationInMinutes < 0 || durationInMinutes > 60) {
            throw new IllegalArgumentException("Sisesta väärtus vahemikus 0-60");
        }
        energySavingMode = true;
    }
}
