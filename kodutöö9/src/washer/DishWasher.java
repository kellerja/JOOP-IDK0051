package washer;

/**
 * Created by Jaanus on 20.11.16.
 */
public class DishWasher {

    public void intensiveWash() {
        System.out.println("Washing");
    }

    public void soak() {
        System.out.println("Soaking");
    }

    public void dry() {
        System.out.println("Drying");
    }

    public void steam() {
        System.out.println("Steaming");
    }

    public void rinse() {
        System.out.println("Rinsing");
    }

    public void startWashingProgram(WashingProgram washingProgram) {
        washingProgram.startCycle(this);
        washingProgram.printDuration();
    }
}
