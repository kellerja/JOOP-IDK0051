package airport;

/**
 * Created by Jaanus on 14.09.16.
 */
public class AirportSecurityDatabase implements SecurityGateDatabase {

    @Override
    public void registerTicket(BoardingPass boardingPass) throws IllegalArgumentException {
        System.out.println("Registreeritud pardakaart nr " +
                boardingPass.getTicketCode() + ": " +
                boardingPass.getPassengerFirstName() + " " +
                boardingPass.getPassengerLastName());
    }
}
