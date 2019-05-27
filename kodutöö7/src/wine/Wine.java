package wine;

/**
 * Created by Jaanus on 5.11.16.
 */
public class Wine {
    private int category;
    private double alcoholByVolume;
    private double magnesiumContent;
    private double flavonoidContent;
    private String slogan;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getAlcoholByVolume() {
        return alcoholByVolume;
    }

    public void setAlcoholByVolume(double alcoholByVolume) {
        this.alcoholByVolume = alcoholByVolume;
    }

    public double getMagnesiumContent() {
        return magnesiumContent;
    }

    public void setMagnesiumContent(double magnesiumContent) {
        this.magnesiumContent = magnesiumContent;
    }

    public double getFlavonoidContent() {
        return flavonoidContent;
    }

    public void setFlavonoidContent(double flavonoidContent) {
        this.flavonoidContent = flavonoidContent;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void addSlogan(String slogan) {
        if (this.slogan == null) {
            setSlogan(slogan);
        } else {
            this.slogan += " " + slogan;
        }
    }

    @Override
    public String toString() {
        return Wine.class +
                "; kategooria=" + getCategory() +
                "; alkoholisisaldus=" + getAlcoholByVolume() +
                "; magneesiumisisaldus=" + getMagnesiumContent() +
                "; flavonoidide sisaldus=" + getFlavonoidContent() +
                "; reklaamlause=" + getSlogan();
    }
}
