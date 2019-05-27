package newspaper;

/**
 * Created by Jaanus on 4.12.16.
 */
public class OrderDeliveryService implements Runnable {

    private String name;
    private UndeliveredOrderDatabase database;

    public OrderDeliveryService(String name, UndeliveredOrderDatabase database) {
        this.name = name;
        this.database = database;
    }

    private void printOrder(Order order) {
        System.out.println("DeliveryService " + name + " delivered order " + order.toString() +
                " Price: " + order.getOrderPrice(
                s -> s.getWeeklyDeliveryAmount() * 0.55 * (s.getOrderMonths() >= 6 ? 0.9 : 1)));
    }

    void deliver() throws InterruptedException {
        database.getOrder().ifPresent(this::printOrder);
    }

    @Override
    public void run() {
        try {
            while (!database.isCompleted() || !database.isEmpty()) {
                if (!database.isEmpty() && database.isCompleted()) {
                    database.forceNotify();
                }
                deliver();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DeliveryService" + name + " has finished! Database is empty: " + database.isEmpty());
    }
}
