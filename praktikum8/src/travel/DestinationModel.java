package travel;

import java.util.function.DoubleFunction;
public interface DestinationModel {
    // return name
    public String getName();
    // return temp in Kelvins
    public double getKelvin();
    // return temp using provided converter method
    public double getAvgWeather(DoubleFunction<Double> tempHandler);
}
