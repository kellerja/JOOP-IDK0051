package client;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Jaanus on 30.09.16.
 */
public class SeniorClient extends Client {

    SeniorClient(long clientCode, LocalDate birthYear) {
        super(clientCode, birthYear);
    }

    private boolean isOver100() {
        return getBirthYear().plusYears(100).compareTo(LocalDate.now()) < 0;
    }

    @Override
    public BigDecimal calculateMonthlyFee() {
        final double monthlyFeeBaseInCents = 100;
        if (isOver100()) return new BigDecimal(0);
        return new BigDecimal((monthlyFeeBaseInCents -
                LocalDate.now().minusYears(getBirthYear().getYear()).getYear()) / 100);
    }
}
