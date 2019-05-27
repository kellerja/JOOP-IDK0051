package washer;

/**
 * Created by Jaanus on 21.11.16.
 */
public class SteamCleanStrategy implements WashingProgram {
    @Override
    public void startCycle(DishWasher washingMachine) {
        washingMachine.steam();
        washingMachine.rinse();
        washingMachine.dry();
    }

    @Override
    public void printDuration() {
        System.out.println("Steam cleaning took 15 minutes.");
    }
}
