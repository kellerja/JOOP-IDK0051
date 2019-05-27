package train.controller;

import train.helper.RailRoadMap;
import train.helper.Route;
import train.stop.Station;
import train.train.ElectricTrain;
import train.train.Train;
import train.user.Inspector;
import train.user.Stowaway;
import train.user.Traveler;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Jaanus on 30.12.16.
 */
public class TrainController {

    private void startDay() throws InterruptedException {
        RailRoadMap map = new RailRoadMap();

        Map<String, Station> stations = createStations();

        createConnections(map, stations);

        populateStations(stations);

        Map<String, Route> routes = createRoutes(stations, map);

        List<Train> trains = createTrains(routes);

        List<Thread> threads = trains.stream().map(Thread::new).collect(Collectors.toList());

        threads.forEach(Thread::start);

        queryStatus(trains, 2500);
    }

    private void queryStatus(List<Train> trains, long everyTimeInMillis) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(everyTimeInMillis);
            trains.forEach(t -> System.out.println(t.getStatus()));
        }
    }

    private List<Train> createTrains(Map<String, Route> routes) {
        List<Train> trains = new ArrayList<>();
        trains.add(new ElectricTrain(routes.get("Tallinn-Kloogaranna"), 20, "T1"));
        trains.add(new ElectricTrain(routes.get("Kloogaranna-Tallinn"), 30, "T2"));
        trains.add(new ElectricTrain(routes.get("Tallinn-RiisipereExpress"), 15, "T3"));
        trains.add(new Train(routes.get("Tallinn-Pärnu"), 40, "T4"));
        trains.add(new Train(routes.get("Tallinn-Piusa"), 60, "T5"));
        trains.add(new Train(routes.get("Narva-Tallinn"), 180, "T6"));
        trains.add(new Train(routes.get("Tallinn-ValgaExpress"), 12, "T7"));
        trains.add(new ElectricTrain(routes.get("Tallinn-PärnuExpress"), 1, "T8"));
        return trains;
    }

    private void populateStations(Map<String, Station> stations) {
        List<Station> stationsList = new ArrayList<>(stations.values());
        final int numberOfTravelers = 250;
        Random rng = new Random();
        for (int i = 0; i < Math.floor(numberOfTravelers * 0.97); i++) {
            stationsList.get(rng.nextInt(stationsList.size()))
                    .addTraveler(new Traveler("Traveler" + i));
        }
        for (int i = 0; i < Math.ceil(numberOfTravelers * 0.03); i++) {
            stationsList.get(rng.nextInt(stationsList.size()))
                    .addTraveler(new Stowaway("Stowaway " + i));
        }
        stations.get("Tallinn").addTraveler(new Inspector("Inspector 1"));
        stations.get("Tallinn").addTraveler(new Inspector("Inspector 2"));
        stations.get("Tallinn").addTraveler(new Inspector("Inspector 3"));
    }

    private void createConnections(RailRoadMap map, Map<String, Station> stations) {
        map.createNewTwoWayElectricRail(stations.get("Tallinn"), stations.get("Lilleküla"), 30);
        map.createNewTwoWayElectricRail(stations.get("Lilleküla"), stations.get("Saue"), 15);
        map.createNewTwoWayElectricRail(stations.get("Saue"), stations.get("Keila"), 16);
        map.createNewElectricRail(stations.get("Keila"), stations.get("Riisipere"), 30);
        map.createNewElectricRail(stations.get("Keila"), stations.get("Klooga"), 12);
        map.createNewElectricRail(stations.get("Klooga"), stations.get("Paldiski"), 28);
        map.createNewElectricRail(stations.get("Klooga"), stations.get("Kloogaranna"), 21);
        map.createNewRail(stations.get("Tallinn"), stations.get("Tallinn-Väike"), 5);
        map.createNewRail(stations.get("Tallinn-Väike"), stations.get("Saku"), 6);
        map.createNewRail(stations.get("Saku"), stations.get("Lohu"), 14);
        map.createNewRail(stations.get("Lohu"), stations.get("Lelle"), 32);
        map.createNewTwoWayRail(stations.get("Lelle"), stations.get("Viljandi"), 64);
        map.createNewTwoWayRail(stations.get("Lelle"), stations.get("Pärnu"), 20);
        map.createNewTwoWayElectricRail(stations.get("Tallinn"), stations.get("Kehra"), 30);
        map.createNewTwoWayElectricRail(stations.get("Kehra"), stations.get("Tapa"), 23);
        map.createNewRail(stations.get("Tapa"), stations.get("Narva"), 47);
        map.createNewRail(stations.get("Tapa"), stations.get("Jõgeva"), 24);
        map.createNewRail(stations.get("Jõgeva"), stations.get("Tartu"), 32);
        map.createNewRail(stations.get("Tartu"), stations.get("Koidula"), 10);
        map.createNewRail(stations.get("Koidula"), stations.get("Piusa"), 20);
        map.createNewTwoWayRail(stations.get("Tartu"), stations.get("Valga"), 20);
    }

    private Map<String, Station> createStations() {
        Map<String, Station> stations = new HashMap<>();
        stations.put("Tallinn", new Station("Tallinn"));
        stations.put("Lilleküla", new Station("Lilleküla"));
        stations.put("Saue", new Station("Saue"));
        stations.put("Keila", new Station("Keila"));
        stations.put("Riisipere", new Station("Riisipere"));
        stations.put("Klooga", new Station("Klooga"));
        stations.put("Kloogaranna", new Station("Kloogaranna"));
        stations.put("Tallinn-Väike", new Station("Tallinn-Väike"));
        stations.put("Saku", new Station("Saku"));
        stations.put("Lohu", new Station("Lohu"));
        stations.put("Lelle", new Station("Lelle"));
        stations.put("Viljandi", new Station("Viljandi"));
        stations.put("Pärnu", new Station("Pärnu"));
        stations.put("Kehra", new Station("Kehra"));
        stations.put("Tapa", new Station("Tapa"));
        stations.put("Narva", new Station("Narva"));
        stations.put("Jõgeva", new Station("Jõgeva"));
        stations.put("Tartu", new Station("Tartu"));
        stations.put("Koidula", new Station("Koidula"));
        stations.put("Piusa", new Station("Piusa"));
        stations.put("Valga", new Station("Valga"));
        return stations;
    }

    private Map<String, Route> createRoutes(Map<String, Station> stations, RailRoadMap map) {
        Map<String, Route> routes = new HashMap<>();

        routes.put("Tallinn-Kloogaranna", new Route("Tallinn-Kloogaranna",
                Stream.concat(
                        map.getPath(stations.get("Tallinn"), stations.get("Kloogaranna")).stream(),
                        map.getPath(stations.get("Klooga"), stations.get("Lilleküla")).stream()
                ).collect(Collectors.toList()), map));
        routes.put("Kloogaranna-Tallinn", new Route("Kloogaranna-Tallinn",
                Arrays.asList(stations.get("Kloogaranna"), stations.get("Klooga"),
                        stations.get("Keila"), stations.get("Saue"),
                        stations.get("Lilleküla"), stations.get("Tallinn"),
                        stations.get("Lilleküla"), stations.get("Saue"),
                        stations.get("Keila"), stations.get("Klooga")), map));
        routes.put("Tallinn-RiisipereExpress", new Route("Tallinn-Riisipere",
                Arrays.asList(stations.get("Tallinn"), stations.get("Keila"),
                        stations.get("Riisipere"), stations.get("Keila")), map));
        routes.put("Tallinn-Pärnu", new Route("Tallinn-Pärnu",
                Arrays.asList(stations.get("Tallinn"), stations.get("Tallinn-Väike"),
                        stations.get("Saku"), stations.get("Lohu"),
                        stations.get("Lelle"), stations.get("Pärnu"),
                        stations.get("Lelle"), stations.get("Lohu"),
                        stations.get("Saku"), stations.get("Tallinn-Väike")), map));
        routes.put("Tallinn-Piusa", new Route("Tallinn-Tartu-Piusa",
                Arrays.asList(stations.get("Tallinn"), stations.get("Kehra"),
                        stations.get("Tapa"), stations.get("Jõgeva"),
                        stations.get("Tartu"), stations.get("Koidula"),
                        stations.get("Piusa"), stations.get("Koidula"),
                        stations.get("Tartu"), stations.get("Jõgeva"),
                        stations.get("Tapa"), stations.get("Kehra")), map));
        routes.put("Narva-Tallinn", new Route("Narva-Tallinn",
                Arrays.asList(stations.get("Narva"), stations.get("Tapa"),
                        stations.get("Kehra"), stations.get("Tallinn"),
                        stations.get("Kehra"), stations.get("Tapa")), map));
        routes.put("Tallinn-ValgaExpress", new Route("Tallinn-Valga",
                Arrays.asList(stations.get("Tallinn"), stations.get("Tapa"),
                        stations.get("Tartu"), stations.get("Valga"),
                        stations.get("Tartu")), map));
        routes.put("Tallinn-PärnuExpress", new Route("Tallinn-Pärnu",
                Arrays.asList(stations.get("Tallinn"), stations.get("Pärnu")), map));
        return routes;
    }

    public static void main(String[] args) {
        try {
            new TrainController().startDay();
            //new TrainController().testTwoWayRail();
            //new TrainController().testElectricTrainNoElectricRail();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void testElectricTrainNoElectricRail() throws InterruptedException {
        RailRoadMap map = new RailRoadMap();

        Station stationTallinn = new Station("Tallinn");
        Station stationTartu = new Station("Tartu");

        map.createNewRail(stationTallinn, stationTartu, 20);

        Route route = new Route("Tallinn-Tartu", Arrays.asList(stationTallinn, stationTartu), map);

        Train train = new ElectricTrain(route, 5, "T");

        Thread thread = new Thread(train);

        thread.start();

        queryStatus(Arrays.asList(train), 10);
    }

    private void testTwoWayRail() throws InterruptedException {
        RailRoadMap map = new RailRoadMap();

        Station stationTallinn = new Station("Tallinn");
        Station stationTartu = new Station("Tartu");

        map.createNewTwoWayRail(stationTallinn, stationTartu, 500);

        List<Station> stationsFromTallinnToTartu = Arrays.asList(stationTallinn, stationTartu);

        Route route1 = new Route("Tallinn-Tartu", stationsFromTallinnToTartu, map);
        Route route2 = new Route("Tartu-Tallinn", Arrays.asList(stationTartu, stationTallinn), map);
        Route route3 = new Route("Tallinn-Tartu", stationsFromTallinnToTartu, map);

        Train train1 = new Train(route1, 10, "T1");
        Train train2 = new Train(route2, 10, "T2");
        Train train3 = new Train(route3, 10, "T3");

        Thread t1 = new Thread(train1);
        Thread t2 = new Thread(train2);
        Thread t3 = new Thread(train3);

        t1.start();
        t2.start();
        t3.start();

        queryStatus(Arrays.asList(train1, train2, train3), 6000);
    }
}
