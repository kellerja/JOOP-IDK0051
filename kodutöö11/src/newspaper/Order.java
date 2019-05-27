package newspaper;

import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

/**
 * Created by Jaanus on 4.12.16.
 */
public class Order {

    private final String name;
    private final String address;
    private final int clientNumber;
    private final int orderMonths;
    private final int numberOfCopies;
    private static final int DAYS_TO_DELIVER = 5;

    public Order(String name, String address, int clientNumber, int orderMonths, int numberOfCopies) {
        this.name = name;
        this.address = address;
        this.clientNumber = clientNumber;
        this.orderMonths = orderMonths;
        this.numberOfCopies = numberOfCopies;
    }

    public int getWeeklyDeliveryAmount() {
        return numberOfCopies * getDaysToDeliver();
    }

    public double getOrderPrice(ToDoubleFunction<Order> priceFunctionHandler) {
        return priceFunctionHandler.applyAsDouble(this);
    }

    int getDaysToDeliver() {
        return DAYS_TO_DELIVER;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Address: " + address +
                " ClientNo: " + clientNumber + " Months: " + orderMonths +
                " Copies: " + numberOfCopies;
    }

    public int getOrderMonths() {
        return orderMonths;
    }
}
