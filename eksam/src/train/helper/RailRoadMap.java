package train.helper;

import train.railroad.ElectricRail;
import train.railroad.Rail;
import train.railroad.TwoWayElectricRail;
import train.railroad.TwoWayRail;
import train.stop.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Jaanus on 30.12.16.
 */
public class RailRoadMap {
    private final List<Rail> rails;

    public RailRoadMap() {
        rails = new ArrayList<>();
    }

    public List<Rail> getPathListBetween(Station origin, Station destination, Predicate<Rail> railConditions) {
        List<Station> path = getPath(origin, destination, railConditions);
        List<Rail> railsInPath = new ArrayList<>();
        for (int i = 0; i < path.size() - 1; i++) {
            railsInPath.add(getNextRail(Arrays.asList(path.get(i), path.get(i + 1))));
        }
        return railsInPath;
    }

    public void createNewRail(Station origin, Station destination, double distance) {
        if (isPossibleRail(origin, destination, distance)) {
            rails.add(new Rail(origin, destination, distance));
        }
    }

    public void createNewElectricRail(Station origin, Station destination, double distance) {
        if (isPossibleRail(origin, destination, distance)) {
            rails.add(new ElectricRail(origin, destination, distance));
        }
    }

    public void createNewTwoWayRail(Station origin, Station destination, double distance) {
        if (isPossibleRail(origin, destination, distance)) {
            rails.add(new TwoWayRail(origin, destination, distance));
        }
    }

    public void createNewTwoWayElectricRail(Station origin, Station destination, double distance) {
        if (isPossibleRail(origin, destination, distance)) {
            rails.add(new TwoWayElectricRail(origin, destination, distance));
        }
    }

    private boolean isPossibleRail(Station origin, Station destination, double distance) {
        return origin != null && destination != null && !origin.equals(destination) && distance > 0;
    }

    private Rail getNextRail(List<Station> path) {
        return rails.parallelStream()
                .filter(s -> s.getSource().equals(path.get(0)) && s.getDestination().equals(path.get(1))
                        || s.getSource().equals(path.get(1)) && s.getDestination().equals(path.get(0)))
                .findAny().get();
    }

    public List<Station> getPath(Station origin, Station destination) {
        return getPath(origin, destination, r -> true);
    }

    private List<Station> getPath(Station origin, Station destination, Predicate<Rail> railConditions) {
        return getPath(origin, destination, new ArrayList<>(), railConditions);
    }

    private List<Station> getPath(Station origin, Station destination, List<Station> path, Predicate<Rail> railConditions) {
        path.add(origin);
        if (origin.equals(destination)) {
            return path;
        }
        List<Station> neighbours = rails.parallelStream()
                .filter(s -> s.getSource().equals(origin) || s.getDestination().equals(origin))
                .filter(railConditions)
                .map(s -> s.getSource().equals(origin) ? s.getDestination() : s.getSource())
                .filter(s -> !path.contains(s))
                .collect(Collectors.toList());
        if (neighbours.contains(destination)) {
            path.add(destination);
            return path;
        }
        for (Station neighbour : neighbours) {
            getPath(neighbour, destination, path, railConditions);
            if (path.contains(destination)) break;
        }
        if (!path.contains(destination)) path.remove(origin);
        return path;
    }
}
