package tickets;

import java.time.LocalDateTime;

/**
 * Created by Jaanus on 12.12.16.
 */
public class TrainTicket extends Ticket {
    private final int trainCart;
    private final int numOfStops;

    public TrainTicket(String destination, double price, LocalDateTime dateTime, int seat, int trainCart, int numOfStops) {
        super(destination, price, dateTime, seat);
        this.trainCart = trainCart;
        this.numOfStops = numOfStops;
    }

    public int getNumOfStops() {
        return numOfStops;
    }

    public int getTrainCart() {
        return trainCart;
    }
}
