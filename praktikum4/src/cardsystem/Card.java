package cardsystem;

import java.math.BigDecimal;

/**
 * Created by Jaanus on 21.09.16.
 */
public interface Card {
    public BigDecimal getBalance();
    public void makePayment(BigDecimal paymentAmount);
}
