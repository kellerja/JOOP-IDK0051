package stockmarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by Jaanus on 7.12.16.
 */
public class StockMarket {
    private final List<StockOrder> stockOrders = new ArrayList<>();

    public void addOrder(StockOrder stockOrder) {
        synchronized (stockOrders) {
            stockOrders.add(stockOrder);
            stockOrders.notifyAll();
        }
    }

    public StockOrder getStockOrder(Predicate<StockOrder> conditionToBuy) throws InterruptedException {
        synchronized (stockOrders) {
            Optional<StockOrder> order = stockOrders.stream().filter(conditionToBuy).findAny();
            while (!order.isPresent()) {
                stockOrders.wait();
                order = stockOrders.stream().filter(conditionToBuy).findAny();
            }
            return order.get();
        }
    }
}
