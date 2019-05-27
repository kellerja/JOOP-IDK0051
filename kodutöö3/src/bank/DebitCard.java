package bank;

import java.math.BigDecimal;

/**
 * Created by Jaanus on 25.09.16.
 */
public class DebitCard implements Card {

    BigDecimal balance;

    public DebitCard() {
        balance = new BigDecimal(10_000.0005);
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void makePayment(BigDecimal paymentAmount) {
        System.out.println("Deebetkaart");
        if (canMakePayment(paymentAmount)) {
            makePaymentCore(paymentAmount);
        } else {
            System.out.println("Kaardil puudub vajalik saldo makse soortamiseks.");
        }
    }

    void makePaymentCore(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    boolean canMakePayment(BigDecimal amount) {
        return balance.compareTo(amount) >= 0;
    }
}
