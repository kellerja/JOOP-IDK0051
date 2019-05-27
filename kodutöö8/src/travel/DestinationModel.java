package travel;

import java.util.function.ToDoubleBiFunction;

public interface DestinationModel {
    // return name
    public DestinationName getName();
    // return temp in Kelvins
    public double getKelvin();
    // return temp using provided converter method
    public double getAvgWeather(ToDoubleBiFunction<Double,Double> tempHandler);
}
