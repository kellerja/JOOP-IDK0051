package travel;

/**
 * Created by Jaanus on 12.11.16.
 */
public class DestinationName {

    private String name;
    private String nameInLocalLanguage;
    private String country;
    private String continent;

    public DestinationName(String name, String nameInLocalLanguage, String country, String continent) {
        this.name = name;
        this.nameInLocalLanguage = nameInLocalLanguage;
        this.country = country;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public String getNameInLocalLanguage() {
        return nameInLocalLanguage;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }
}
