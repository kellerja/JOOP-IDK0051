package car;

/**
 * Created by Jaanus on 16.11.16.
 */
public class LowFuelConsumptionDrivingStrategy implements DrivingStrategy {

    private int accelerationMode = 1;
    private double maxSpeed = 50;

    @Override
    public int getAccelerationMode() {
        return accelerationMode;
    }

    @Override
    public boolean shouldStopForBlinkingTrafficLight(double metersToTrafficLight) {
        return true;
    }

    @Override
    public double maxSpeed() {
        return maxSpeed;
    }
}
