package travel;

/**
 * Created by Jaanus on 9.11.16.
 */
public class Traveller {

    void travel() {
        Destination destination = new Destination(
                new DestinationName("Rooma", "Roma", "Itaalia", "Euroopa"),
                new Temperature(300, 310));
        System.out.println("Ilma lambdadeta");
        System.out.println(destination.convertKelvinTempToCelsiusTemp());
        System.out.println(destination.convertKelvinTempToFahrenheitTemp());

        System.out.println("Lambdade kasutamine");
        double celsius = destination.getAvgWeather((k, s) -> (k + s) / 2 - 273.15);
        System.out.println(celsius);
        double fahrenheit = destination.getAvgWeather((k, s) -> (k + s) / 2 * 9 / 5 - 459.67);
        System.out.println(fahrenheit);

        System.out.println("Nime printimine erinevate vormistustega");
        destination.printDestinationName(n -> System.out.println(n.getName() +
                " (" + n.getNameInLocalLanguage() + "), " +
                n.getCountry() + ", " +
                n.getContinent()));
        destination.printDestinationName(n -> System.out.println(n.getName() + ", " + n.getCountry()));
        destination.printDestinationName(n -> System.out.println(n.getName()));
        destination.printDestinationName(n -> System.out.println(n.getName().toUpperCase()));
        destination.printDestinationName(n -> System.out.println(n.getName() + ", " + n.getCountry().toUpperCase()));
    }

    public static void main(String[] args) {
        new Traveller().travel();
    }
}
