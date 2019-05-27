package seat;

import java.util.Optional;

/**
 * Created by Jaanus on 19.10.16.
 */
public class Seat {
    private static final int WIDTH_IN_CM = 60;
    private final int maximumBackrestAngleInDegrees = 28;
    private boolean seatWarmerState;
    private String seatAttendant;
    private int backRestAngleInDegrees;

    public static Seat getInstanceByAttendant(String seatAttendant) {
        if (isBusinessClassAttendant(seatAttendant)) {
            return new BusinessClassSeat(seatAttendant);
        }
        return new Seat(seatAttendant);
    }

    public static Seat getNewInstanceOfSeat() {
        return new Seat(0);
    }

    public static Seat getNewInstanceOfSleepSeat() {
        return new SleepSeat();
    }

    private static boolean isBusinessClassAttendant(String seatAttendant) {
        return seatAttendant.equals("Tiina") || seatAttendant.equals("Riina") || seatAttendant.equals("Miina") || seatAttendant.equals("Tiit");
    }

    Seat(String seatAttendant) {
        this.seatAttendant = seatAttendant;
    }

    Seat(int backRestAngleInDegrees) {
        this.backRestAngleInDegrees = backRestAngleInDegrees;
    }

    public int getBackRestAngleInDegrees() {
        return backRestAngleInDegrees;
    }

    public void setBackrestUpright() {
        backRestAngleInDegrees = 0;
    }

    public void enableSeatWarmer() {
        seatWarmerState = true;
    }

    public void lowerBackRest() {
        if (canLowerBackRest()) {
            backRestAngleInDegrees += 7;
        } else {
            setBackrestUpright();
            throw new SeatLoweringLimitExceeded();
        }
    }

    public void raiseBackRest() {
        if (canRaiseBackRest()) {
            backRestAngleInDegrees -= 7;
        }
    }

    private boolean canRaiseBackRest() {
        return getBackRestAngleInDegrees() > 0;
    }

    private boolean canLowerBackRest() {
        return getBackRestAngleInDegrees() < getMaximumBackrestAngleInDegrees();
    }

    int getMaximumBackrestAngleInDegrees() {
        return maximumBackrestAngleInDegrees;
    }

    public Optional<String> getSeatAttendant() {
        return Optional.ofNullable(seatAttendant);
    }

    @Override
    public String toString() {
        String message =  getSeatType() + "\n\tSeat angle: " + getBackRestAngleInDegrees();
        if (getSeatAttendant().isPresent()) {
            message += "\n\tSteward/Stewardess: " + getSeatAttendant().get();
        } else {
            message += "\n\tSeat has no steward/stewardess";
        }
        return message;
    }

    String getSeatType() {
        return "Common seat";
    }

    public boolean isSeatWarmerOn() {
        return seatWarmerState;
    }
}
