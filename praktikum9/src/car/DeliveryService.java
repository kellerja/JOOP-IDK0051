package car;

/**
 * Created by Jaanus on 16.11.16.
 */
public class DeliveryService {
    void makeDelivery(DrivingStrategy drivingStrategy) {
        DrivingAI drivingAI = new DrivingAI(drivingStrategy);
        drivingAI.setRouteParameters(250, 3);
        drivingAI.drive();
        System.out.println("Trip time: " + drivingAI.expectedTripTime());
        System.out.println("Fuel consumption: " + drivingAI.expectedFuelConsumptionInLiters());
        drivingAI.stopAtBlinkingTrafficLight(5);
        drivingAI.stopAtBlinkingTrafficLight(11);
        drivingAI.stop();
    }

    public static void main(String[] args) {
        System.out.println("Using fast driving strategy:");
        new DeliveryService().makeDelivery(new FastDrivingStrategy());
        System.out.println("Using slow driving strategy:");
        new DeliveryService().makeDelivery(new LowFuelConsumptionDrivingStrategy());
        System.out.println("Using optimal driving strategy:");
        new DeliveryService().makeDelivery(new OptimalDrivingStrategy());
    }
}
