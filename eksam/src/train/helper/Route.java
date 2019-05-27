package train.helper;

import train.railroad.Rail;
import train.stop.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Jaanus on 30.12.16.
 */
public class Route {

    private final List<Station> stops;
    private final RailRoadMap railRoadMap;
    private int currentStopPointer;
    private int numberOfCompletions;
    private final String name;

    public Route(String name, List<Station> stops, RailRoadMap railRoadMap) {
        this.name = name;
        this.stops = stops;
        if (stops == null || stops.isEmpty()) {
            stops = new ArrayList<>();
            stops.add(new Station("Tallinn"));
        }
        this.railRoadMap = railRoadMap;
    }

    public void updateStopPointer() {
        currentStopPointer++;
        if (currentStopPointer >= stops.size()) {
            incrementCompletionNumber();
            currentStopPointer %= stops.size();
        }
    }

    private void incrementCompletionNumber() {
        numberOfCompletions++;
    }

    private Station getNextStop() {
        return stops.get((currentStopPointer + 1) % stops.size());
    }

    public List<Station> getFutureStations() {
        return stops.subList((currentStopPointer + 1) % stops.size(), stops.size());
    }

    public Station getFirstStation() {
        return stops.get(0);
    }

    public List<Rail> getRail(Station currentStation, Predicate<Rail> railConditions) {
        return railRoadMap.getPathListBetween(currentStation, getNextStop(),
                railConditions);
    }

    public int getNumberOfCompletions() {
        return numberOfCompletions;
    }

    public String getName() {
        return name;
    }
}
