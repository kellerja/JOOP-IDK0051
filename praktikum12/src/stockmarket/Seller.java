package stockmarket;

import java.util.function.Supplier;

/**
 * Created by Jaanus on 7.12.16.
 */
public class Seller implements Runnable {

    private StockMarket stockMarket;
    private int numOfSales;

    public Seller(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
        this.numOfSales = 100;
    }

    @Override
    public void run() {
        for (int i=0;i < numOfSales;i++) {
            StockOrder order;
            if (i % 3 == 0) {
                order = new StockOrder("TKM1T", "Tallinna Kaubamaja", 80.0, 2000);
            } else if (i % 4 == 0) {
                order = new StockOrder("TAL1T", "Tallink Group", 8.0, 200);
            } else {
                order = new StockOrder("LHV", "LHV Group", 1.0, 20);
            }
            stockMarket.addOrder(order);
        }
    }
}
