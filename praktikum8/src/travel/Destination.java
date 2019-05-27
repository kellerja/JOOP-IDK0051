package travel;

import java.util.function.DoubleFunction;

/**
 * Created by Jaanus on 9.11.16.
 */
public class Destination implements DestinationModel {

    private String name;
    private double avgTempInKelvin;

    public Destination(String name, double avgTempInKelvin) {
        this.name = name;
        this.avgTempInKelvin = avgTempInKelvin;
    }

    static double convertKelvinTempToCelsiusTemp(double tempInKelvin) {
        return tempInKelvin - 273.15;
    }

    static double convertKelvinTempToFahrenheitTemp(double tempInKelvin) {
        return tempInKelvin * 9 / 5 - 459.67;
    }

    double convertKelvinTempToCelsiusTemp() {
        return avgTempInKelvin - 273.15;
    }

    double convertKelvinTempToFahrenheitTemp() {
        return avgTempInKelvin * 9 / 5 - 459.67;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getKelvin() {
        return avgTempInKelvin;
    }

    @Override
    public double getAvgWeather(DoubleFunction<Double> tempHandler) {
        return tempHandler.apply(avgTempInKelvin);
    }
}
