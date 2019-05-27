package tickets;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created by Jaanus on 12.12.16.
 */
public class TrainTicketGenerator extends PlaneTicketGenerator {

    public TrainTicketGenerator(String name, TicketDatabase database) {
        super(name, database);
    }

    public TrainTicketGenerator(String name, TicketDatabase database, int limit) {
        super(name, database, limit);
    }

    @Override
    Ticket createTicket() {
        Random random = new Random();
        LocalDateTime localDateTime = LocalDateTime.now();
        Ticket ticket = new TrainTicket(random.nextBoolean() ? "Rome" : "Tallinn",
                Math.abs(random.nextInt(random.nextBoolean() ? 5 : 60) + random.nextDouble()),
                localDateTime, 2, 1, 12);
        return ticket;
    }
}
