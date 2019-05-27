package travel;

/**
 * Created by Jaanus on 12.11.16.
 */
public class Temperature {

    private double minimumTemperature;
    private double maximumTemperature;

    public Temperature(double minimumTemperature, double maximumTemperature) {
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }
}
