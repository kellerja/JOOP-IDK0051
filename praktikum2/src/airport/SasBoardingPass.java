package airport;

/**
 * Created by Jaanus on 14.09.16.
 */
public class SasBoardingPass implements BoardingPass {
    private long ticketCode;
    private String firstName;
    private String lastName;

    public SasBoardingPass(long ticketCode, String firstName, String lastName) {
        this.ticketCode = ticketCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getPassengerFirstName() {
        return firstName;
    }

    @Override
    public String getPassengerLastName() {
        return lastName;
    }

    @Override
    public long getTicketCode() {
        return ticketCode;
    }
}
