package seat;

/**
 * Created by Jaanus on 19.10.16.
 */
public class SleepSeat extends Seat {
    private static final int WIDTH_IN_CM = 70;
    private static final int MAXIMUM_BACKREST_ANGLE_IN_DEGREES = 42;

    SleepSeat() {
        super(MAXIMUM_BACKREST_ANGLE_IN_DEGREES);
    }

    @Override
    public void lowerBackRest() {
        super.lowerBackRest();
        super.enableSeatWarmer();
    }

    @Override
    public int getMaximumBackrestAngleInDegrees() {
        return MAXIMUM_BACKREST_ANGLE_IN_DEGREES;
    }

    @Override
    String getSeatType() {
        return "Seat for sleeping";
    }
}
