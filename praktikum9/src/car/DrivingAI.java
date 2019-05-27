package car;

/**
 * Created by Jaanus on 16.11.16.
 */
public class DrivingAI {

    private DrivingStrategy drivingStrategy;
    private double routeLength;
    private int numberOfStops;
    private boolean freezer;

    public DrivingAI(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
    }

    public void setRouteParameters(double routeLength, int numberOfStops) {
        this.routeLength = routeLength;
        this.numberOfStops = numberOfStops;
    }

    public double getAccelerationMode() {
        return drivingStrategy.getAccelerationMode();
    }

    public double drive() {
        System.out.println("Driving");
        return drivingStrategy.maxSpeed();
    }

    public void stop() {
        System.out.println("Stopping");
    }

    public void setFreezer(boolean freezer) {
        this.freezer = freezer;
    }

    public void stopAtBlinkingTrafficLight(double metersToTrafficLight) {
        if(drivingStrategy.shouldStopForBlinkingTrafficLight(metersToTrafficLight)) {
            stop();
        }
    }

    public double expectedFuelConsumptionInLiters() {
        double fuelConsumptionFor100KM = drivingStrategy.maxSpeed() <= 70 ? 10 : 14;
        double fuelRequiredForTrip = routeLength / 100 * fuelConsumptionFor100KM;
        return getAccelerationMode() * 0.1 + fuelRequiredForTrip;
    }

    public double expectedTripTime() {
        return routeLength / drivingStrategy.maxSpeed();
    }
}
