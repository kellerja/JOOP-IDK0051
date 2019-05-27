package travel;

import java.util.function.Consumer;
import java.util.function.ToDoubleBiFunction;

/**
 * Created by Jaanus on 9.11.16.
 */
public class Destination implements DestinationModel {

    private DestinationName name;
    private Temperature temperature;

    public Destination(DestinationName destinationName, Temperature temperature) {
        this.name = destinationName;
        this.temperature = temperature;
    }

    static double convertKelvinTempToCelsiusTemp(double tempInKelvin) {
        return tempInKelvin - 273.15;
    }

    static double convertKelvinTempToFahrenheitTemp(double tempInKelvin) {
        return tempInKelvin * 9 / 5 - 459.67;
    }

    double convertKelvinTempToCelsiusTemp() {
        return getKelvin() - 273.15;
    }

    double convertKelvinTempToFahrenheitTemp() {
        return getKelvin() * 9 / 5 - 459.67;
    }

    void printDestinationName(Consumer<DestinationName> destinationNameConsumer) {
        destinationNameConsumer.accept(getName());
    }

    @Override
    public DestinationName getName() {
        return name;
    }

    @Override
    public double getKelvin() {
        return (temperature.getMaximumTemperature() + temperature.getMinimumTemperature()) / 2;
    }

    @Override
    public double getAvgWeather(ToDoubleBiFunction<Double,Double> tempHandler) {
        return tempHandler.applyAsDouble(temperature.getMinimumTemperature(), temperature.getMaximumTemperature());
    }
}
