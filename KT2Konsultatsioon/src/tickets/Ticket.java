package tickets;

import java.time.LocalDateTime;

/**
 * Created by Jaanus on 12.12.16.
 */
public class Ticket {

    private final String destination;
    private final double price;
    private final LocalDateTime dateTime;
    private final int seat;

    public Ticket(String destination, double price, LocalDateTime dateTime, int seat) {
        this.destination = destination;
        this.price = price;
        this.dateTime = dateTime;
        this.seat = seat;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getSeat() {
        return seat;
    }

    public boolean isPlaneTicket() {
        return false;
    }

    @Override
    public String toString() {
        return getClass() + " to " + destination + " by " + dateTime.toString() + " with seat " + seat + " costing " + price;
    }
}
