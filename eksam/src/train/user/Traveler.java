package train.user;

import train.helper.Route;
import train.stop.Station;
import train.train.Train;

import java.util.List;
import java.util.Random;

/**
 * Created by Jaanus on 30.12.16.
 */
public class Traveler {

    private final String name;
    private Station destination;
    private Train ticket;
    private final Random rng;

    public Traveler(String name) {
        this.name = name;
        ticket = null;
        rng = new Random();
    }

    public boolean isInspector() {
        return false;
    }

    public boolean isDestination(Station currentStation) {
        return currentStation.equals(destination);
    }

    public void generateDestination(List<Station> stops) {
        destination = stops.get(rng.nextInt(stops.size()));
    }

    public boolean isLastTrain(Train train) {
        return train.equals(ticket);
    }

    public boolean hasTicket(Train train) {
        return train.equals(ticket);
    }

    public void setTicket(Train train) {
        ticket = train;
    }

    public String getName() {
        return name;
    }
}
