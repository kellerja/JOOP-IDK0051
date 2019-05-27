package client;

import cardsystem.CreditCard;
import cardsystem.DebitCard;

import java.util.Optional;

/**
 * Created by Jaanus on 28.09.16.
 */
public class Client {
    private long clientCode;
    private DebitCard debitCard;
    private CreditCard creditCard;

    public Client(long clientCode) {
        this.clientCode = clientCode;
    }

    public void setDebitCard(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public long getClientCode() {
        return clientCode;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Optional<CreditCard> getCreditCardOptional() {
        return Optional.ofNullable(creditCard);
    }
}
