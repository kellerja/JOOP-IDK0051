package washer;

/**
 * Created by Jaanus on 20.11.16.
 */
public class Main {
    public static void main(String[] args) {
        DishWasher dishWasher = new DishWasher();
        WashingProgram washingProgram = new FullCleanStrategy();
        dishWasher.startWashingProgram(washingProgram);
        washingProgram = new QuickStrategy();
        dishWasher.startWashingProgram(washingProgram);
        washingProgram = new SteamCleanStrategy();
        dishWasher.startWashingProgram(washingProgram);
    }
}
