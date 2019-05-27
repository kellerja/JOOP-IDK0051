import cardsystem.BankClientGateway;
import client.Client;

import java.math.BigDecimal;

/**
 * Created by Jaanus on 28.09.16.
 */
public class Main {
    public static void main(String[] args) {
        Client client1 = BankClientGateway.getClientInstance(34343);
        Client client2 = BankClientGateway.getClientInstance(333);
        Client client3 = BankClientGateway.getClientInstance(2);
        Client client4 = BankClientGateway.getClientInstance(79);
        Client clientSameAs1 = BankClientGateway.getClientInstance(34343);
        Client clientSameAs2 = BankClientGateway.getClientInstance(333);
        Client clientSameAs3 = BankClientGateway.getClientInstance(2);
        Client clientSameAs4 = BankClientGateway.getClientInstance(1);

        System.out.println("testClientObjectsAreSame");
        System.out.println("\tclient1 == clientSameAs1: " + (client1 == clientSameAs1));
        System.out.println("\tclient1 == clientSameAs2: " + (client1 == clientSameAs2));
        System.out.println("\tclient3 == clientSameAs3: " + (client3 == clientSameAs3));
        System.out.println();
        System.out.println("testBalanceOfThirdClientVsOtherClients");
        System.out.println("\tclient1 CC balance: " + client1.getDebitCard().getBalance());
        System.out.println("\tclient2 CC balance: " + client2.getDebitCard().getBalance());
        System.out.println("\tclient3 CC balance: " + client3.getDebitCard().getBalance());
        System.out.println("\tclient4 CC balance: " + client4.getDebitCard().getBalance());
        System.out.println("testUseDebitCard");
        System.out.println("\tclient1 balance before payment of 300 eur: " + client1.getDebitCard().getBalance());
        client1.getDebitCard().makePayment(new BigDecimal(300));
        System.out.println("\tclient1 balance after payment of 300 eur:" + client1.getDebitCard().getBalance());
        System.out.println();
        System.out.println("testUseCreditCardWithNull");
        System.out.println("\tclient1 credit card object value: " + client1.getCreditCard());
        if (client1.getCreditCard() != null) {
            System.out.println("\tclient1 credit card make payment of 400 eur");
            client1.getCreditCard().makePayment(new BigDecimal(400));
            System.out.println("\t\tclient1 balance: " + client1.getCreditCard().getBalance());
        }
        System.out.println("\tclient4 credit card object value: " + client4.getCreditCard());
        if (client4.getCreditCard() != null) {
            System.out.println("\tclient4 credit card make payment of 400 eur");
            client4.getCreditCard().makePayment(new BigDecimal(400));
            System.out.println("\t\tclient4 balance: " + client4.getCreditCard().getBalance());
        }
        System.out.println();
        System.out.println("testUseCreditCardWithOprional");
        System.out.println("\tclient2 credit card object value: " + client2.getCreditCardOptional());
        if (client2.getCreditCardOptional().isPresent()) {
            System.out.println("\tclient2 credit card make payment of 400 eur");
            client2.getCreditCardOptional().get().makePayment(new BigDecimal(400));
            System.out.println("\t\tclient2 balance: " + client2.getCreditCardOptional().get().getBalance());
        }
        System.out.println("\tclient4 credit card object value: " + client4.getCreditCardOptional());
        if (client4.getCreditCardOptional().isPresent()) {
            System.out.println("\tclient4 credit card make payment of 400 eur");
            client4.getCreditCardOptional().get().makePayment(new BigDecimal(400));
            System.out.println("\t\tclient4 balance: " + client4.getCreditCardOptional().get().getBalance());
        }
    }
}
