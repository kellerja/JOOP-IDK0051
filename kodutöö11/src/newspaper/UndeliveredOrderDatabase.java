package newspaper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jaanus on 4.12.16.
 */
public class UndeliveredOrderDatabase {
    private final List<Order> orders = new ArrayList<>();
    private volatile boolean completed = false;

    public void addOrder(Order order) {
        synchronized (orders) {
            orders.add(order);
            orders.notifyAll();
        }
    }

    public Optional<Order> getOrder() throws InterruptedException {
        synchronized (orders) {
            while (orders.size() == 0 && !completed) {
                orders.wait();
            }
            return orders.size() == 0 ? Optional.empty() : Optional.of(orders.remove(0));
        }
    }

    public void markOrdersAsCompleted() {
        completed = true;
        synchronized (orders) {
            orders.notifyAll();
        }
    }

    public boolean isEmpty() {
        synchronized (orders) {
            return orders.isEmpty();
        }
    }

    public void forceNotify() {
        synchronized (orders) {
            orders.notifyAll();
        }
    }

    public boolean isCompleted() {
        return completed;
    }
}
