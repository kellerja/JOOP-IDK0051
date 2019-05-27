package tickets;

import java.util.function.Predicate;

/**
 * Created by Jaanus on 12.12.16.
 */
public class Client implements Runnable {

    private final String name;
    private final Predicate<Ticket> buyingCondition;
    private TicketDatabase database;

    public Client(String name, Predicate<Ticket> buyingCondition, TicketDatabase database) {
        this.name = name;
        this.buyingCondition = buyingCondition;
        this.database = database;
    }

    void buyTicket() throws InterruptedException {
        database.buyTicket(buyingCondition).ifPresent(s -> System.out.println(name + " bought " + s.toString()));
    }

    @Override
    public void run() {
        try {
            while (database.isOpen()) {
                buyTicket();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
