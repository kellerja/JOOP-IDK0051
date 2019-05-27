package tickets;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created by Jaanus on 12.12.16.
 */
public class PlaneTicketGenerator implements Runnable{

    private String name;
    private TicketDatabase database;
    private int limit;
    private int count;

    public PlaneTicketGenerator(String name, TicketDatabase database) {
        this.name = name;
        this.database = database;
        limit = Integer.MAX_VALUE;
    }

    public PlaneTicketGenerator(String name, TicketDatabase database, int limit) {
        this(name, database);
        this.limit = limit;
    }

    Ticket createTicket() {
        Random random = new Random();
        LocalDateTime localDateTime = LocalDateTime.now();
        Ticket ticket = new PlaneTicket("Tallinn", Math.abs(random.nextInt(600) + random.nextDouble()), localDateTime, 1);
        return ticket;
    }

    @Override
    public void run() {
        try {
            while (database.isOpen() && count++ < limit) {
                Ticket ticket = createTicket();
                database.sellTicket(ticket);
                Thread.sleep(45);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
