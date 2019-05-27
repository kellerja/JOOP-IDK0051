package ticket;

/**
 * Created by Jaanus on 23.11.16.
 */
public class ServiceTicketGenerator implements Runnable{

    private int id;
    private TicketStorage storage;
    private int counter;

    public ServiceTicketGenerator(int id, TicketStorage storage) {
        this.id = id;
        this.storage = storage;
    }

    public ServiceTicket createTicket() {
        return new ServiceTicket(generateId());
    }

    private int generateId() {
        return Integer.parseInt(Integer.toString(id) + counter++);
    }

    @Override
    public void run() {
        try {
            cycleTickets();
        } catch (InterruptedException e) {
            System.out.println("Generator " + id + " halted");
        }
    }

    private void cycleTickets() throws InterruptedException {
        while (!Thread.interrupted()) {
            storage.addTicket(createTicket());
            Thread.sleep(10);
        }
    }
}
