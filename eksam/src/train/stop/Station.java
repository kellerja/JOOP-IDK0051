package train.stop;

import train.user.Traveler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Jaanus on 30.12.16.
 */
public class Station {

    private final String name;
    private final List<Traveler> travelers;

    public Station(String name) {
        this.name = name;
        travelers = new ArrayList<>();
    }

    public void addTraveler(Traveler traveler) {
        synchronized (travelers) {
            travelers.add(traveler);
        }
    }

    public List<Traveler> getTravelersFiltered(Predicate<Traveler> travelerCondition, int limit) {
        synchronized (travelers) {
            List<Traveler> toTrain = travelers.stream()
                    .filter(travelerCondition).limit(limit)
                    .collect(Collectors.toList());
            travelers.removeAll(toTrain);
            return toTrain;
        }
    }

    public String getName() {
        return name;
    }
}
