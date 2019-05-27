package grinder;

/**
 * Created by Jaanus on 5.10.16.
 */
public class EspressoGrinder extends Grinder {
    private static final double GRANULARITY = 0.3;

    @Override
    public double grind() {
        super.grind();
        return GRANULARITY;
    }

}
