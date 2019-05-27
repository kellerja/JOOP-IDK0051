package train.railroad;

import train.stop.Station;

/**
 * Created by Jaanus on 31.12.16.
 */
public class ElectricRail extends Rail{
    public ElectricRail(Station source, Station destination, double distance) {
        super(source, destination, distance);
    }

    @Override
    public boolean isElectric() {
        return true;
    }
}
