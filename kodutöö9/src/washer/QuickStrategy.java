package washer;

/**
 * Created by Jaanus on 21.11.16.
 */
public class QuickStrategy implements WashingProgram {
    @Override
    public void startCycle(DishWasher washingMachine) {
        washingMachine.rinse();
        washingMachine.dry();
    }

    @Override
    public void printDuration() {
        System.out.println("Quick cleaning took 10 minutes.");
    }
}
