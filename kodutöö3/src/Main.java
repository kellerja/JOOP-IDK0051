import bank.Card;
import bank.CreditCard;
import bank.DebitCard;
import bank.DebitCardWithNFC;

import java.math.BigDecimal;

/**
 * Created by Jaanus on 25.09.16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Deebet kaart");
        DebitCard debitCard = new DebitCard();
        System.out.println("Kaardi esialgne saldo " + debitCard.getBalance());
        debitCard.makePayment(new BigDecimal("5.78"));
        System.out.println("Kaardi saldo pärast 5.78€ makset " + debitCard.getBalance());
        debitCard.makePayment(new BigDecimal("500.678"));
        System.out.println("Kaardi saldo pärast 500.678€ makset " + debitCard.getBalance());
        debitCard.makePayment(new BigDecimal("9693.5425"));
        System.out.println("Kaardi saldo pärast 9 693.5425€ makset " + debitCard.getBalance());
        debitCard.makePayment(new BigDecimal("50507.66"));
        System.out.println("Kaardi saldo pärast 50 507.66€ makset " + debitCard.getBalance());
        System.out.println();
        System.out.println("Krediit kaart");
        CreditCard creditCard = new CreditCard();
        System.out.println("Kaardi esialgne saldo " + creditCard.getBalance());
        creditCard.makePayment(new BigDecimal("5.78"));
        System.out.println("Kaardi saldo pärast 5.78€ makset " + creditCard.getBalance());
        creditCard.makePayment(new BigDecimal("500.678"));
        System.out.println("Kaardi saldo pärast 500.678€ makset " + creditCard.getBalance());
        creditCard.makePayment(new BigDecimal("9693.5425"));
        System.out.println("Kaardi saldo pärast 9 693.5425€ makset " + creditCard.getBalance());
        creditCard.makePayment(new BigDecimal("50507.66"));
        System.out.println("Kaardi saldo pärast 50 507.66€ makset " + creditCard.getBalance());
        System.out.println();
        System.out.println("Deebet kaart NFC funktsionaalsusega");
        DebitCardWithNFC nfcCard = new DebitCardWithNFC();
        System.out.println("Kaardi esialgne saldo " + nfcCard.getBalance());
        nfcCard.makePayment(new BigDecimal("5.78"));
        System.out.println("Kaardi saldo pärast 5.78€ makset " + nfcCard.getBalance());
        nfcCard.makePayment(new BigDecimal("500.678"));
        System.out.println("Kaardi saldo pärast 500.678€ makset " + nfcCard.getBalance());
        nfcCard.makePayment(new BigDecimal("9693.5425"));
        System.out.println("Kaardi saldo pärast 9 693.5425€ makset " + nfcCard.getBalance());
        nfcCard.makePayment(new BigDecimal("50507.66"));
        System.out.println("Kaardi saldo pärast 50 507.66€ makset " + nfcCard.getBalance());
        System.out.println("NFC maksed");
        nfcCard.makeNFCPayment(new BigDecimal("13"));
        System.out.println("Kaardi saldo pärast 13€ makset " + nfcCard.getBalance());
        nfcCard.makeNFCPayment(new BigDecimal("300"));
        System.out.println("Kaardi saldo pärast 300€ makset " + nfcCard.getBalance());
        nfcCard.makeNFCPayment(new BigDecimal("20"));
        System.out.println("Kaardi saldo pärast 20€ makset " + nfcCard.getBalance());
        for (int i = 0; i < 6; i++) {
            nfcCard.makeNFCPayment(new BigDecimal("20"));
        }
        System.out.println("Kaardi saldo pärast 6*20€ makset " + nfcCard.getBalance());
        nfcCard.makeNFCPayment(new BigDecimal("18"));
        System.out.println("Kaardi saldo pärast 18€ makset " + nfcCard.getBalance());
        nfcCard.makeNFCPayment(new BigDecimal("17"));
        System.out.println("Kaardi saldo pärast 17€ makset " + nfcCard.getBalance());
        nfcCard.makeNFCPayment(new BigDecimal("1"));
        System.out.println("Kaardi saldo pärast 1€ makset " + nfcCard.getBalance());
        nfcCard.makeNFCPayment(new BigDecimal("0.1"));
        System.out.println("Kaardi saldo pärast 0.1€ makset " + nfcCard.getBalance());
        System.out.println();
    }
}
