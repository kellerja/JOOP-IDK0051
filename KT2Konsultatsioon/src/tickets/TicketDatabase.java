package tickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by Jaanus on 12.12.16.
 */
public class TicketDatabase {

    private final List<Ticket> tickets;
    private volatile boolean openStatus;

    public TicketDatabase() {
        tickets = new ArrayList<>();
        openStatus = true;
    }

    public void sellTicket(Ticket ticket) {
        synchronized (tickets) {
            tickets.add(ticket);
            tickets.notifyAll();
        }
    }

    public Optional<Ticket> buyTicket(Predicate<Ticket> purchaseCondition) throws InterruptedException {
        synchronized (tickets) {
            while (openStatus && tickets.stream().filter(purchaseCondition).count() == 0) {
                tickets.wait();
            }
            Optional<Ticket> ticket = tickets.stream().filter(purchaseCondition).findFirst();
            ticket.ifPresent(tickets::remove);
            return ticket;
        }
    }

    public void closeDatabase() {
        openStatus = false;
        synchronized (tickets) {
            tickets.notifyAll();
        }
    }

    public boolean isOpen() {
        return openStatus;
    }
}
