package ticket;

/**
 * Created by Jaanus on 23.11.16.
 */
public class ServiceHandler implements Runnable {

    private String name;
    private TicketStorage storage;

    public ServiceHandler(String name, TicketStorage storage) {
        this.name = name;
        this.storage = storage;
    }

    public void handleTicket(ServiceTicket ticket) {
        System.out.println(name + " " + ticket.toString());
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            storage.getTicket().ifPresent(this::handleTicket);
        }
    }
}
