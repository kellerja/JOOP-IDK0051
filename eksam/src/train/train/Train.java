package train.train;

import train.helper.Route;
import train.stop.Station;
import train.user.Traveler;
import train.railroad.Rail;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Jaanus on 30.12.16.
 */
public class Train implements Runnable{

    private static final int DAILY_TRIPS = 6;
    private Route route;
    private final int seats;
    private final List<Traveler> passengers;
    private final String trainID;
    private long lastTripTimeInMillis;
    private Station currentStation;
    private int speed;
    private String status;
    private final Random rng;

    public Train(Route route, int seats, String trainID) {
        this.route = route;
        this.seats = seats;
        this.trainID = trainID;
        passengers = new ArrayList<>();
        currentStation = route.getFirstStation();
        speed = 100;
        rng = new Random();
    }

    @Override
    public void run() {
        try {
            while (route.getNumberOfCompletions() < DAILY_TRIPS) {
                makeStop();
                if (!travel()) break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        makeFinalStop();
    }

    private void makeStop() {
        setStatus("stopped at " + currentStation.getName() + " station");
        int passengersSizeOnArrival = passengers.size();
        letPassengersOff();
        System.out.println("Train " + trainID + " arrived at " + currentStation.getName()
                + " on line " + route.getName() + " with " + passengersSizeOnArrival
                + " passengers, where " + (passengersSizeOnArrival - passengers.size())
                + " arrived at their destination in " + lastTripTimeInMillis + " ms!");
        int oldPassengersSize = passengers.size();
        letPassengersOn();
        if (isTicketInspectorOnBoard()) checkForTickets();
        System.out.println("Train " + trainID
                + " departed from " + currentStation.getName()
                + " on line " + route.getName()
                + " with " + passengers.size() + " passengers (" + (passengers.size() - oldPassengersSize) + " new)");
    }

    private boolean isTicketInspectorOnBoard() {
        return passengers.stream().filter(Traveler::isInspector).count() > 0;
    }

    private boolean travel() throws InterruptedException {
        List<Rail> railPathToNextStop = route.getRail(currentStation, getRailConditions());
        lastTripTimeInMillis = 0;
        if (railPathToNextStop.isEmpty()) return false;
        for (Rail rail : railPathToNextStop) {
            Station nextStation = getNextStation(rail);
            setStatus("waiting for track between " + currentStation.getName() + " and " + nextStation.getName() + " to open up");
            rail.startUsing(currentStation);
            long travelTimeInMillis = getTravelTimeInMillis(rail);
            setStatus("traveling between " + currentStation.getName() + " and " + nextStation.getName());
            Thread.sleep(travelTimeInMillis);
            rail.stopUsing(nextStation);
            currentStation = nextStation;
            lastTripTimeInMillis += travelTimeInMillis;
        }
        route.updateStopPointer();
        return true;
    }

    private Station getNextStation(Rail rail) {
        return rail.getSource().equals(currentStation) ? rail.getDestination() : rail.getSource();
    }

    private long getTravelTimeInMillis(Rail rail) {
        return (long) ((rail.getDistance() / speed) * 1000);
    }

    private void makeFinalStop() {
        setStatus("completed with route");
        System.out.println("Train " + trainID
                + " arrived at " + currentStation.getName()
                + " on line " + route.getName()
                + " with " + passengers.size() + " passengers.");
        passengers.removeAll(passengers.stream()
                .peek(currentStation::addTraveler)
                .collect(Collectors.toList()));
    }

    private void letPassengersOn() {
        passengers.addAll(currentStation
                .getTravelersFiltered(s -> !s.isLastTrain(this), seats - passengers.size())
                .stream()
                .peek(p -> p.generateDestination(route.getFutureStations()))
                .peek(p -> p.setTicket(this))
                .collect(Collectors.toList()));
    }

    private void letPassengersOff() {
        passengers.removeAll(passengers.stream()
                .filter(p -> p.isDestination(currentStation))
                .peek(currentStation::addTraveler)
                .collect(Collectors.toList()));
    }

    private void checkForTickets() {
        Path path = Paths.get("./eksam/log", "stowaways.txt");
        try (Writer file = Files.newBufferedWriter(path,
                StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            passengers.removeAll(passengers.stream()
                    .filter(p -> rng.nextInt(100) < 69 && !p.hasTicket(this))
                    .peek(currentStation::addTraveler)
                    .peek(p -> {
                        try {
                            file.write(LocalDateTime.now() + " "
                                    + p.getName() + " was caught riding without ticket on train "
                                    + trainID + ".\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    })
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Predicate<Rail> getRailConditions() {
        return r -> true;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = "Train " + trainID + " on line " + route.getName()
                + " with " + passengers.size() + " passengers is currently " + status + ".";
    }
}
