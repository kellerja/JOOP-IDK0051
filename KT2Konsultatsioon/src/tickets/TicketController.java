package tickets;

/**
 * Created by Jaanus on 12.12.16.
 */
public class TicketController {

    private void openTicketMarket() throws InterruptedException {
        TicketDatabase database = new TicketDatabase();

        PlaneTicketGenerator planeTicketGenerator = new PlaneTicketGenerator("Plane ticket generator", database);
        TrainTicketGenerator trainTicketGenerator = new TrainTicketGenerator("Train ticket generator", database);

        Client clientToRome = new Client("A", s -> s.getDestination().equals("Rome"), database);
        Client clientTravelsByPlane = new Client("B", Ticket::isPlaneTicket, database);
        Client clientByCheapTrains = new Client("C", s -> !s.isPlaneTicket() && s.getPrice() <= 30, database);
        Client clientRich = new Client("D", s -> s.isPlaneTicket() && s.getPrice() >= 500
                || !s.isPlaneTicket() && s.getPrice() >= 10, database);

        Thread planeGeneratorThread = new Thread(planeTicketGenerator);
        Thread trainGeneratorThread = new Thread(trainTicketGenerator);
        Thread client1 = new Thread(clientToRome);
        Thread client2 = new Thread(clientTravelsByPlane);
        Thread client3 = new Thread(clientByCheapTrains);
        Thread client4 = new Thread(clientRich);

        planeGeneratorThread.start();
        trainGeneratorThread.start();
        client1.start();
        client2.start();
        client3.start();
        client4.start();

        Thread.sleep(5000);

        database.closeDatabase();
    }

    public static void main(String[] args) {
        try {
            new TicketController().openTicketMarket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
