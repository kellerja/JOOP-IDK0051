package ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jaanus on 23.11.16.
 */
public class TicketStorage {

    private List<ServiceTicket> storage;

    public TicketStorage() {
        storage = new ArrayList<>();
    }

    public synchronized void addTicket(ServiceTicket ticket) {
        storage.add(ticket);
    }

    public Optional<ServiceTicket> getTicket() {
        return Optional.ofNullable(getTicketOrNull());
    }

    private synchronized ServiceTicket getTicketOrNull() {
        return storage.isEmpty() ? null : storage.remove(0);
    }
}
