package newspaper;

/**
 * Created by Jaanus on 4.12.16.
 */
public class ClientGenerator implements Runnable {

    private UndeliveredOrderDatabase databaseToAdd;

    public ClientGenerator(UndeliveredOrderDatabase databaseToAdd) {
        this.databaseToAdd = databaseToAdd;
    }

    void createClient(int clientNumber) {
        String name = "a";
        String address = "B";
        int orderDurationInMonths = 3;
        int numberOfCopies = 1;
        getDatabaseToAdd().addOrder(new Order(name, address, clientNumber,
                orderDurationInMonths, numberOfCopies));
    }

    void createBusinessClient(int clientNumber, int orderDurationInMonths) {
        String name = "a";
        String address = "B";
        int numberOfCopies = 1;
        String registryNumber = "1";
        getDatabaseToAdd().addOrder(new BusinessOrder(name, address, clientNumber,
                orderDurationInMonths, numberOfCopies, registryNumber));
    }

    UndeliveredOrderDatabase getDatabaseToAdd() {
        return databaseToAdd;
    }

    @Override
    public void run() {
        final int numberOfClients = 900;
        final int numberOfBusinessClients = 450;
        final int numberOfBusinessClientsLongOrder = 250;
        try {
            for (int i = 0; i < numberOfClients; i++) {
                createClient(i);
                Thread.sleep(2);
            }
            for (int i = 1; i <= numberOfBusinessClients; i++) {
                createBusinessClient(numberOfClients + i, 3);
                Thread.sleep(2);
            }
            for (int i = 1; i <= numberOfBusinessClientsLongOrder; i++) {
                createBusinessClient(numberOfClients + numberOfBusinessClients + i, 7);
                Thread.sleep(2);
            }
            databaseToAdd.markOrdersAsCompleted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
