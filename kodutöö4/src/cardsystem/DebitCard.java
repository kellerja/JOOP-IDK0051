package cardsystem;

import java.math.BigDecimal;

/**
 * Created by Jaanus on 21.09.16.
 */
public class DebitCard implements Card {

    BigDecimal balance;

    public DebitCard() {
        balance = new BigDecimal(10_000.0005);
    }

    public DebitCard(BigDecimal initialBalance) {
        balance = initialBalance;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void makePayment(BigDecimal paymentAmount) {
        makePaymentCore(paymentAmount);
    }

    void makePaymentCore(BigDecimal amount) {
        balance = balance.subtract(amount);
    }
}
