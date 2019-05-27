package train.train;

import train.helper.Route;
import train.railroad.Rail;

import java.util.function.Predicate;

/**
 * Created by Jaanus on 31.12.16.
 */
public class ElectricTrain extends Train {

    public ElectricTrain(Route route, int seats, String trainID) {
        super(route, seats, trainID);
    }

    @Override
    public Predicate<Rail> getRailConditions() {
        return Rail::isElectric;
    }
}
