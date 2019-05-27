package travel;

/**
 * Created by Jaanus on 9.11.16.
 */
public class Traveller {

    void travel() {
        Destination destination = new Destination("", 300);
        System.out.println("Ilma lambdadeta");
        System.out.println(destination.convertKelvinTempToCelsiusTemp());
        System.out.println(destination.convertKelvinTempToFahrenheitTemp());

        System.out.println("Lambdade kasutamine");
        double celsius = destination.getAvgWeather(k -> k - 273.15);
        System.out.println(celsius);
        double fahrenheit = destination.getAvgWeather(k -> k * 9 / 5 - 459.67);
        System.out.println(fahrenheit);

        System.out.println("Kasutada staatilise meetodi viidet");
        celsius = destination.getAvgWeather(Destination::convertKelvinTempToCelsiusTemp);
        System.out.println(celsius);
        fahrenheit = destination.getAvgWeather(Destination::convertKelvinTempToFahrenheitTemp);
        System.out.println(fahrenheit);
    }

    public static void main(String[] args) {
        new Traveller().travel();
    }
}
