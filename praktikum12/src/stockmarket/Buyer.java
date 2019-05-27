package stockmarket;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

/**
 * Created by Jaanus on 7.12.16.
 */
public class Buyer implements Callable<Double> {

    private StockMarket stockMarket;
    private Predicate<StockOrder> conditionToBuy;

    public Buyer(StockMarket stockMarket, Predicate<StockOrder> conditionToBuy) {
        this.stockMarket = stockMarket;
        this.conditionToBuy = conditionToBuy;
    }

    @Override
    public Double call() throws Exception {
        double amountSpent = 0.0;
        for (int i = 0; i < 100; i++) {
            StockOrder order = stockMarket.getStockOrder(conditionToBuy);
            System.out.println(order);
            amountSpent += order.getTotalPrice();
        }
        return amountSpent;
    }
}
