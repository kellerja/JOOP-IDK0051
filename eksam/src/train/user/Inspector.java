package train.user;

/**
 * Created by Jaanus on 4.01.17.
 */
public class Inspector extends Traveler {

    public Inspector(String name) {
        super(name);
    }

    @Override
    public boolean isInspector() {
        return true;
    }

}
