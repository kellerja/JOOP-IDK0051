package newspaper;

/**
 * Created by Jaanus on 4.12.16.
 */
public class BusinessOrder extends Order {
    private String registerCode;
    private static final int DAYS_TO_DELIVER = 6;

    public BusinessOrder(String name, String address, int clientNumber, int orderMonths, int numberOfCopies, String registerCode) {
        super(name, address, clientNumber, orderMonths, numberOfCopies);
        this.registerCode = registerCode;
    }

    @Override
    int getDaysToDeliver() {
        return DAYS_TO_DELIVER;
    }

    @Override
    public String toString() {
        return super.toString() + " RegisterCode: " + registerCode;
    }
}
