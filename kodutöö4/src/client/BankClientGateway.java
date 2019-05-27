package client;

import cardsystem.CreditCard;
import cardsystem.DebitCard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jaanus on 28.09.16.
 */
public class BankClientGateway {
    private final static BigDecimal INITIAL_BALANCE = new BigDecimal(1000);
    private final static BigDecimal BONUS = new BigDecimal(300);

    private static List<Client> clients = new ArrayList<>();

    private static boolean isValidAsClient(LocalDate birthYear) {
        final long minimumAcceptedAge = 7;
        return birthYear.plusYears(minimumAcceptedAge).compareTo(LocalDate.now()) > 0;
    }

    private static boolean isSenior(LocalDate birthYear) {
        final long minimumSeniorAge = 65;
        return birthYear.plusYears(minimumSeniorAge).compareTo(LocalDate.now()) < 0;
    }

    private static Client createClient(long idCode, LocalDate birthYear) {
        if (isValidAsClient(birthYear)) {
            return null;
        }
        Client newClient;
        if (isSenior(birthYear)) {
            newClient = new SeniorClient(idCode, birthYear);
        } else {
            newClient = new Client(idCode, birthYear);
        }
        clients.add(newClient);
        addCardToClient(idCode, newClient);
        return newClient;
    }

    private static void addCardToClient(long idCode, Client newClient) {
        newClient.setDebitCard(getClientBaseSize() % 3 == 0 ?
                new DebitCard(INITIAL_BALANCE.add(BONUS)) :
                new DebitCard(INITIAL_BALANCE));
        newClient.setCreditCard(idCode < 80 ? new CreditCard() : null);
    }

    public static Optional<Client> getClientInstance(long clientCode, LocalDate birthYear) {
        for (Client client : clients) {
            if (client.getClientCode() == clientCode) {
                return Optional.of(client);
            }
        }
        Client newClient = createClient(clientCode, birthYear);
        return Optional.ofNullable(newClient);
    }

    public static int getClientBaseSize() {
        return clients.size();
    }
}
