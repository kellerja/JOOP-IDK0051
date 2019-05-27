package bank;

import java.math.BigDecimal;

/**
 * Created by Jaanus on 25.09.16.
 */
public interface Card {
    public BigDecimal getBalance();
    public void makePayment(BigDecimal paymentAmount);
}
