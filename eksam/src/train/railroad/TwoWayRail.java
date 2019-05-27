package train.railroad;

import train.stop.Station;

/**
 * Created by Jaanus on 31.12.16.
 */
public class TwoWayRail extends Rail {
    private final Rail railDestinationToSource;
    private volatile boolean inUse;

    public TwoWayRail(Station source, Station destination, double distance) {
        super(source, destination, distance);
        railDestinationToSource = new Rail(destination, source, distance);
    }

    @Override
    public void startUsing(Station start) throws InterruptedException {
        if (start.equals(getSource())) {
            super.startUsing(start);
        } else {
            synchronized (railDestinationToSource) {
                while (inUse) railDestinationToSource.wait();
                inUse = true;
            }
        }
    }

    @Override
    public void stopUsing(Station stop) {
        if (stop.equals(getDestination())) {
            super.stopUsing(stop);
        } else {
            synchronized (railDestinationToSource) {
                inUse = false;
                railDestinationToSource.notifyAll();
            }
        }
    }
}
