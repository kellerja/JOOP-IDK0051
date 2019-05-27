package bank;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by Jaanus on 25.09.16.
 */
public class CreditCard extends DebitCard {

    private BigDecimal creditLimit;

    public CreditCard() {
        super();
        creditLimit = new BigDecimal("700");
    }

    public CreditCard(BigDecimal initialBalance) {
        this();
        this.balance = initialBalance;
    }

    public BigDecimal getBalance(Calendar calendar) {
        return getBalance();
    }

    @Override
    public void makePayment(BigDecimal paymentAmount) {
        System.out.println("Krediitkaart");
        if (canMakePayment(paymentAmount.subtract(creditLimit))) {
            makePaymentCore(paymentAmount);
        } else {
            System.out.println("Kaardil puudub vajalik krediit makse sooritamiseks");
        }
    }
}
