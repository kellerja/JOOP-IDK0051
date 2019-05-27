package washer;

/**
 * Created by Jaanus on 21.11.16.
 */
public class FullCleanStrategy implements WashingProgram {
    @Override
    public void startCycle(DishWasher washingMachine) {
        washingMachine.steam();
        washingMachine.rinse();
        washingMachine.soak();
        washingMachine.intensiveWash();
        washingMachine.rinse();
        washingMachine.dry();
    }

    @Override
    public void printDuration() {
        System.out.println("Full cleaning took 30 minutes.");
    }
}
