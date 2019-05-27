package seat;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

/**
 * Created by Jaanus on 19.10.16.
 */
public class SleepSeatTest {
    private Seat seat;
    @Before
    public void setUp() {
        seat = Seat.getNewInstanceOfSleepSeat();
    }

    @Test
    public void defaultBackrestAngle() {
        assertEquals(42, seat.getBackRestAngleInDegrees());
    }

    @Test
    public void seatToString() {
        String seatInfo = seat.toString();
        assertEquals(seatInfo, "Seat for sleeping\n\tSeat angle: 42\n\tSeat has no steward/stewardess");
    }
}
