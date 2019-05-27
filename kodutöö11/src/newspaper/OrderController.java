package newspaper;

/**
 * Created by Jaanus on 4.12.16.
 */
public class OrderController {
    private void system() {
        UndeliveredOrderDatabase database = new UndeliveredOrderDatabase();

        ClientGenerator clientGenerator = new ClientGenerator(database);

        Thread clientManager = new Thread(clientGenerator);

        clientManager.start();

        OrderDeliveryService deliveryService1 = new OrderDeliveryService("Service 1", database);
        OrderDeliveryService deliveryService2 = new OrderDeliveryService("Service 2", database);
        OrderDeliveryService deliveryService3 = new OrderDeliveryService("Service 3", database);
        OrderDeliveryService deliveryService4 = new OrderDeliveryService("Service 4", database);

        Thread service1 = new Thread(deliveryService1);
        Thread service2 = new Thread(deliveryService2);
        Thread service3 = new Thread(deliveryService3);
        Thread service4 = new Thread(deliveryService4);

        service1.start();
        service2.start();
        service3.start();
        service4.start();
    }

    public static void main(String[] args) {
        new OrderController().system();
    }
}
