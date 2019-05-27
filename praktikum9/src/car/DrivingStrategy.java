package car;

/**
 * Created by Jaanus on 16.11.16.
 */
public interface DrivingStrategy {
    int getAccelerationMode();

    boolean shouldStopForBlinkingTrafficLight(double metersToTrafficLight);

    double maxSpeed();
}
