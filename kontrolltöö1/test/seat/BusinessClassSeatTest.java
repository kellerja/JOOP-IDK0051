package seat;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/**
 * Created by Jaanus on 19.10.16.
 */
public class BusinessClassSeatTest {
    private Seat seat;

    @Before
    public void setUp() {
        seat = Seat.getInstanceByAttendant("Miina");
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
        seat.lowerBackRest();
        assertEquals(35, seat.getBackRestAngleInDegrees());
    }

    @Test
    public void seatToString() {
        String seatInfo = seat.toString();
        assertEquals(seatInfo, "Business class seat\n\tSeat angle: 0\n\tSteward/Stewardess: Miina");
    }
}
