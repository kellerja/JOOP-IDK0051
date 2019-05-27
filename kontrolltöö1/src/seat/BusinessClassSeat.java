package seat;

/**
 * Created by Jaanus on 19.10.16.
 */
public class BusinessClassSeat extends Seat {
    private static final int WIDTH_IN_CM = 70;
    private final int maximumBackrestAngleInDegrees = 35;

    BusinessClassSeat(String seatAttendant) {
        super(seatAttendant);
    }

    BusinessClassSeat(int backRestAngleInDegrees) {
        super(backRestAngleInDegrees);
    }

    @Override
    public int getMaximumBackrestAngleInDegrees() {
        return maximumBackrestAngleInDegrees;
    }

    @Override
    String getSeatType() {
        return "Business class seat";
    }
}
