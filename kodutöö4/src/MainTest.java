import client.BankClientGateway;
import client.Client;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Jaanus on 2.10.16.
 */
public class MainTest {
    private BigDecimal currentClientInitialBalance() {
        return BankClientGateway.getClientBaseSize() % 3 == 0 ? new BigDecimal(1300) : new BigDecimal(1000);
    }

    @Test
    public void testGetClientInstance() {
        Optional<Client> clientOptional = BankClientGateway.getClientInstance(33, LocalDate.ofYearDay(1990, 40));
        assertTrue(clientOptional.isPresent());
    }

    @Test
    public void testClientBasic() {
        Optional<Client> temporaryClient;
        Client client;
        BigDecimal clientBalance;

        temporaryClient = BankClientGateway.getClientInstance(1, LocalDate.ofYearDay(1983, 15));
        assertTrue(temporaryClient.isPresent());
        client = temporaryClient.get();
        clientBalance = client.getDebitCard().getBalance();
        if (BankClientGateway.getClientBaseSize() % 3 == 0) {
            assertEquals(currentClientInitialBalance(), clientBalance);
        }
        BigDecimal modifier = new BigDecimal(333);
        client.getDebitCard().makePayment(modifier);
        assertEquals(clientBalance.subtract(modifier),
                client.getDebitCard().getBalance());

        temporaryClient = BankClientGateway.getClientInstance(3, LocalDate.ofYearDay(1990, 66));
        assertTrue(temporaryClient.isPresent());
        client = temporaryClient.get();
        clientBalance = client.getDebitCard().getBalance();
        if (BankClientGateway.getClientBaseSize() % 3 == 0) {
            assertEquals(currentClientInitialBalance(), clientBalance);
        }

        temporaryClient = BankClientGateway.getClientInstance(4, LocalDate.ofYearDay(1995, 88));
        assertTrue(temporaryClient.isPresent());
        client = temporaryClient.get();
        clientBalance = client.getDebitCard().getBalance();
        if (BankClientGateway.getClientBaseSize() % 3 == 0) {
            assertEquals(currentClientInitialBalance(), clientBalance);
        }
    }

    @Test
    public void testClientUnderRequiredAge() {
        //failed client
        Optional<Client> clientOptional = BankClientGateway.getClientInstance(48, LocalDate.now().minusYears(2));
        assertFalse(clientOptional.isPresent());

        //failed client
        clientOptional = BankClientGateway.getClientInstance(12, LocalDate.now().minusYears(6));
        assertFalse(clientOptional.isPresent());

        clientOptional = BankClientGateway.getClientInstance(13, LocalDate.now().minusYears(7));
        assertTrue(clientOptional.isPresent());
    }

    @Test
    public void testMonthlyPaymentBasic() {
        Optional<Client> temporaryClientOptional;
        Client client;
        BigDecimal initialBalance;

        temporaryClientOptional = BankClientGateway.getClientInstance(5, LocalDate.ofYearDay(1968, 300));
        assertTrue(temporaryClientOptional.isPresent());
        client = temporaryClientOptional.get();
        initialBalance = currentClientInitialBalance();
        client.payMonthlyFee();
        assertEquals(initialBalance.subtract(new BigDecimal(1)), client.getDebitCard().getBalance());
    }

    @Test
    public void testMonthlyPaymentSenior() {
        LocalDate birth = LocalDate.ofYearDay(1950, 296);
        Optional<Client> clientOptional = BankClientGateway.getClientInstance(9, birth);
        assertTrue(clientOptional.isPresent());
        Client client = clientOptional.get();
        BigDecimal clientBalance = client.getDebitCard().getBalance();
        client.payMonthlyFee();
        assertEquals(clientBalance.subtract(new BigDecimal((100.0 - LocalDate.now().minusYears(birth.getYear()).getYear()) / 100)), client.getDebitCard().getBalance());

        birth = LocalDate.ofYearDay(1500, 44);
        clientOptional = BankClientGateway.getClientInstance(5643, birth);
        assertTrue(clientOptional.isPresent());
        client = clientOptional.get();
        clientBalance = client.getDebitCard().getBalance();
        client.payMonthlyFee();
        assertEquals(clientBalance, client.getDebitCard().getBalance());
    }

    @Test
    public void testSearchClientByID() {
        LocalDate birth = LocalDate.ofYearDay(1990, 55);
        Optional<Client> c1 = BankClientGateway.getClientInstance(999, birth);
        Optional<Client> c2 = BankClientGateway.getClientInstance(998, birth);
        Optional<Client> c3 = BankClientGateway.getClientInstance(997, birth);
        Optional<Client> c4 = BankClientGateway.getClientInstance(996, birth);
        Optional<Client> c5 = BankClientGateway.getClientInstance(998, LocalDate.now());

        assertEquals(c1.get(), BankClientGateway.getClientInstance(999, LocalDate.now()).get());
        assertEquals(c2.get(), BankClientGateway.getClientInstance(998, birth).get());
        assertEquals(c2.get(), c5.get());
        assertEquals(c3.get(), BankClientGateway.getClientInstance(997, LocalDate.MAX).get());
        assertEquals(c4.get(), BankClientGateway.getClientInstance(996, LocalDate.MIN).get());
    }
}
