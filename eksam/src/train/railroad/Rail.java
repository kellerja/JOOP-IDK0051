package train.railroad;

import train.stop.Station;

/**
 * Created by Jaanus on 30.12.16.
 */
public class Rail {

    private final Station source;
    private final Station destination;
    private final double distance;
    private volatile boolean inUse;

    public Rail(Station source, Station destination, double distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return source + "-" + destination;
    }

    public double getDistance() {
        return distance;
    }

    public Station getDestination() {
        return destination;
    }

    public Station getSource() {
        return source;
    }

    public synchronized void startUsing(Station start) throws InterruptedException {
        while (inUse) wait();
        inUse = true;
    }

    public synchronized void stopUsing(Station stop) {
        inUse = false;
        notifyAll();
    }

    public boolean isElectric() {
        return false;
    }
}
