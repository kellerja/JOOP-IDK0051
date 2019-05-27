package car;

/**
 * Created by Jaanus on 16.11.16.
 */
public class OptimalDrivingStrategy extends LowFuelConsumptionDrivingStrategy {

    private int accelerationMode = 3;
    private double maxSpeed = 70;

    @Override
    public int getAccelerationMode() {
        return accelerationMode;
    }

    @Override
    public double maxSpeed() {
        return maxSpeed;
    }
}
