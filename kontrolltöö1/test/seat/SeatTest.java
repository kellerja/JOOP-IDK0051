package seat;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/**
 * Created by Jaanus on 19.10.16.
 */
public class SeatTest {
    private Seat seat;

    @Before
    public void setUp() {
        seat = Seat.getInstanceByAttendant("Paul");
    }

    @Test
    public void lowerSeat() {
        seat.lowerBackRest();
        assertEquals(7, seat.getBackRestAngleInDegrees());
    }

    @Test
    public void lowerSeatToMaximum() {
        seat.lowerBackRest();
        seat.lowerBackRest();
        seat.lowerBackRest();
        seat.lowerBackRest();
        assertEquals(28, seat.getBackRestAngleInDegrees());
    }

    @Test(expected = SeatLoweringLimitExceeded.class)
    public void lowerSeatMoreThanMaximum() {
        seat.lowerBackRest();
        seat.lowerBackRest();
        seat.lowerBackRest();
        seat.lowerBackRest();
        seat.lowerBackRest();
    }

    @Test
    public void raiseSeat() {
        seat.lowerBackRest();
        seat.raiseBackRest();
        assertEquals(0, seat.getBackRestAngleInDegrees());
    }

    @Test
    public void raiseSeatWhenSeatUpright() {
        seat.raiseBackRest();
        assertEquals(0, seat.getBackRestAngleInDegrees());
    }

    @Test
    public void seatToString() {
        String seatInfo = seat.toString();
        assertEquals(seatInfo, "Common seat\n\tSeat angle: 0\n\tSteward/Stewardess: Paul");
    }

    @Test
    public void getSeatAttendant() {
        assertEquals(seat.getSeatAttendant().get(), "Paul");
    }

    @Test
    public void getSeatInstance() {
        assertEquals(Seat.class, Seat.getInstanceByAttendant("a").getClass());
    }

    @Test
    public void getBusinessSeatInstance() {
        assertEquals(BusinessClassSeat.class, Seat.getInstanceByAttendant("Tiit").getClass());
    }

    @Test
    public void setSeatUpright() {
        seat.lowerBackRest();
        seat.lowerBackRest();
        seat.setBackrestUpright();
        assertEquals(0, seat.getBackRestAngleInDegrees());
    }

    @Test
    public void enableSeatWarmer() {
        seat.enableSeatWarmer();
        assertEquals(true, seat.isSeatWarmerOn());
    }

}
