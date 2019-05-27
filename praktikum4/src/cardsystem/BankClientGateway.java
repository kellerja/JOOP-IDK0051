package cardsystem;

import client.Client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaanus on 28.09.16.
 */
public class BankClientGateway {
    private final static BigDecimal INITIAL_BALANCE = new BigDecimal(1000);
    private final static BigDecimal BONUS = new BigDecimal(300);

    private static List<Client> clients = new ArrayList<>();

    private static Client createClient(long idCode) {
        Client newClient = new Client(idCode);
        newClient.setDebitCard(clients.size() % 3 == 0 ?
                new DebitCard(INITIAL_BALANCE) :
                new DebitCard(INITIAL_BALANCE.add(BONUS)));
        newClient.setCreditCard(idCode < 80 ? new CreditCard() : null);
        return newClient;
    }

    public static Client getClientInstance(long clientCode) {
        for (Client client : clients) {
            if (client.getClientCode() == clientCode) {
                return client;
            }
        }
        Client newClient = createClient(clientCode);
        clients.add(newClient);
        return newClient;
    }
}
