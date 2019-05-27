package cardsystem;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by Jaanus on 21.09.16.
 */
public class CreditCard extends DebitCard {

    public CreditCard() {
        super();
    }

    public CreditCard(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }

    public BigDecimal getBalance(Calendar calendar) {
        return getBalance();
    }

    @Override
    public void makePayment(BigDecimal paymentAmount) {
        makePaymentCore(paymentAmount);
    }
}
