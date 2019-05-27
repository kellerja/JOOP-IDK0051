package tickets;

import java.time.LocalDateTime;

/**
 * Created by Jaanus on 12.12.16.
 */
public class PlaneTicket extends Ticket {
    public PlaneTicket(String destination, double price, LocalDateTime dateTime, int seat) {
        super(destination, price, dateTime, seat);
    }

    public double getCancelingFee() {
        return getPrice() * 0.1;
    }

    @Override
    public boolean isPlaneTicket() {
        return true;
    }
}
