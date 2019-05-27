package bank;

import java.math.BigDecimal;

/**
 * Created by Jaanus on 25.09.16.
 */
public class DebitCardWithNFC extends DebitCard {

    private final BigDecimal SINGLE_SMALL_PAYMENT_LIMIT = new BigDecimal("20");
    private BigDecimal remainingSmallPaymentAmount;

    public DebitCardWithNFC() {
        remainingSmallPaymentAmount = new BigDecimal("150");
    }

    public void makeNFCPayment(BigDecimal paymentAmount) {
        if (canMakeNFCPayment(paymentAmount)) {
            remainingSmallPaymentAmount = remainingSmallPaymentAmount.subtract(paymentAmount);
            makePayment(paymentAmount);
        } else {
            System.out.println("antud NFC makset pole võimalik sooritada");
        }
    }

    boolean canMakeNFCPayment(BigDecimal amount) {
        return amount.compareTo(SINGLE_SMALL_PAYMENT_LIMIT) <= 0
                && super.canMakePayment(amount)
                && remainingSmallPaymentAmount.subtract(amount).compareTo(new BigDecimal("0")) >= 0;
    }
}
