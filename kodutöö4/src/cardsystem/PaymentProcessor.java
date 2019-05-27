package cardsystem;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Jaanus on 21.09.16.
 */
public class PaymentProcessor {
    public void makeMassPayment(List<Card> cards) {
        cards.forEach(card -> card.makePayment(new BigDecimal("3.0454547")));
    }
}
