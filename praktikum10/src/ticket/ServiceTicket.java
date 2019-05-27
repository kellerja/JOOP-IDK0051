package ticket;

import java.util.List;

/**
 * Created by Jaanus on 23.11.16.
 */
public class ServiceTicket {
    private int id;

    public ServiceTicket(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
