package car;

/**
 * Created by Jaanus on 16.11.16.
 */
public class FastDrivingStrategy implements DrivingStrategy {

    private int accelerationMode = 5;
    private double maxSpeed = 90;

    @Override
    public int getAccelerationMode() {
        return accelerationMode;
    }

    @Override
    public boolean shouldStopForBlinkingTrafficLight(double metersToTrafficLight) {
        return metersToTrafficLight <= 10;
    }

    @Override
    public double maxSpeed() {
        return maxSpeed;
    }
}
