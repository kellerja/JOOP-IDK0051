package seatApplication;

import seat.Seat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaanus on 19.10.16.
 */
public class SeatController {
    List<Seat> seats = new ArrayList<>();

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public void addSeat(String seatAttendant) {
        seats.add(Seat.getInstanceByAttendant(seatAttendant));
    }

    public int numberOfSeats() {
        return seats.size();
    }

    public void changeAllSeatsUpright() {
        for (Seat seat: seats) {
            seat.setBackrestUpright();
        }
    }
}
