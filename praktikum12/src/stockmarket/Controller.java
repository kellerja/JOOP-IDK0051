package stockmarket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Jaanus on 7.12.16.
 */
public class Controller {

    private void openStockMarket() {
        StockMarket stockMarket = new StockMarket();

        Seller seller = new Seller(stockMarket);

        Buyer buyerCheap = new Buyer(stockMarket, s -> s.getTotalPrice() < 200);
        Buyer buyerTallink = new Buyer(stockMarket, s -> s.getName().equals("Tallink Group"));
        Buyer buyerLHV = new Buyer(stockMarket, s -> s.getName().equals("Tallinna Kaubamaja") || s.getName().equals("LHV Group"));
        Buyer buyerLargeAmount = new Buyer(stockMarket, s -> s.getNumOfStocks() >= 30);

        ExecutorService executor = Executors.newFixedThreadPool(6);

        List<Future<Double>> moneySpent = new ArrayList<>();

        for (int i = 0;i < 100; i++) {
            executor.execute(new Seller(stockMarket));
            Future<Double> spent1 = executor.submit(buyerCheap);
            Future<Double> spent2 = executor.submit(buyerLargeAmount);
            Future<Double> spent3 = executor.submit(buyerTallink);
            Future<Double> spent4 = executor.submit(buyerLHV);

            moneySpent.add(spent1);
            moneySpent.add(spent2);
            moneySpent.add(spent3);
            moneySpent.add(spent4);
        }

            System.out.println(moneySpent.stream().mapToDouble((doubleFuture) -> {
                try {
                    return doubleFuture.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                return 0;
            }).sum());
    }

    public static void main(String[] args) {
        new Controller().openStockMarket();
    }
}
