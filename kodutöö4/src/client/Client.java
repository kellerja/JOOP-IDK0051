package client;

import cardsystem.CreditCard;
import cardsystem.DebitCard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by Jaanus on 28.09.16.
 */
public class Client {
    private long clientCode;
    private DebitCard debitCard;
    private CreditCard creditCard;
    private LocalDate birthYear;
    private static final BigDecimal MONTHLY_FEE = new BigDecimal(1);

    Client(long clientCode, LocalDate birthYear) {
        this.clientCode = clientCode;
        this.birthYear = birthYear;
    }

    void setDebitCard(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    void setCreditCard(CreditCard creditCard) {
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

    public LocalDate getBirthYear() {
        return birthYear;
    }

    public void payMonthlyFee() {
        getDebitCard().makePayment(calculateMonthlyFee());
    }

    public BigDecimal calculateMonthlyFee() {
        return MONTHLY_FEE;
    }
}
