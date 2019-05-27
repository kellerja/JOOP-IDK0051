package stockmarket;

/**
 * Created by Jaanus on 7.12.16.
 */
public class StockOrder {

    private final String alias;
    private final String name;
    private final double price;
    private final int numOfStocks;

    StockOrder(String alias, String name, double price, int numOfStocks) {
        this.alias = alias;
        this.name = name;
        this.price = price;
        this.numOfStocks = numOfStocks;
    }

    public double getTotalPrice() {
        return price * numOfStocks;
    }

    public String getAlias() {
        return alias;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumOfStocks() {
        return numOfStocks;
    }

    @Override
    public String toString() {
        return getClass() + " ('" + alias + "') " + name + " Price: " + price + " $ Number of stocks: " + numOfStocks;
    }
}
