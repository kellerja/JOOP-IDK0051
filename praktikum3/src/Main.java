import cardsystem.Card;
import cardsystem.CreditCard;
import cardsystem.DebitCard;
import cardsystem.PaymentProcessor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Jaanus on 21.09.16.
 */
public class Main {
    public static void main(String[] args) {
        Card debitcard = new DebitCard();
        Card creditcard = new CreditCard();
        DebitCard card = new CreditCard();

        debitcard.makePayment(new BigDecimal(10));
        creditcard.makePayment(new BigDecimal(20));
        card.makePayment(new BigDecimal(33.43));

        System.out.println();
        System.out.println(debitcard.getBalance());
        System.out.println(creditcard.getBalance());
        System.out.println(card.getBalance());
        System.out.println();

        System.out.println("Krediirkaardil on 2 getBalance meetodit:");
        CreditCard myCreditCard = (CreditCard) card;
        System.out.println(myCreditCard.getBalance());
        System.out.println(myCreditCard.getBalance(new GregorianCalendar()));
        System.out.println();

        System.out.println("Krediitkaarti on võimalik luua algväärtusega ja ilma algväärtuseta:");
        Card newCreditCard = new CreditCard(new BigDecimal(55553));
        System.out.println(newCreditCard.getBalance());
        System.out.println();

        System.out.println("mass makse:");
        List<Card> cards = new ArrayList<>();
        cards.add(debitcard);
        cards.add(creditcard);
        cards.add(myCreditCard);
        cards.add(card);
        cards.add(newCreditCard);
        System.out.println("\tBefore:");
        cards.forEach(c -> System.out.println(c.getBalance()));
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.makeMassPayment(cards);
        System.out.println("\tAfter:");
        cards.forEach(c -> System.out.println(c.getBalance()));
    }
}
