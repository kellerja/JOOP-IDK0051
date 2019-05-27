package aircontoller;

import airlineservice.AirlineTicketService;
import airlineservice.SasAirlineTicketService;
import airport.AirportSecurityDatabase;
import airport.SecurityGateDatabase;

/**
 * Created by Jaanus on 14.09.16.
 */
public class GateController {

    private AirlineTicketService airlineTicketService;
    private SecurityGateDatabase securityGateDatabase;

    public GateController() {
        airlineTicketService = new SasAirlineTicketService();
        securityGateDatabase = new AirportSecurityDatabase();
    }

    public void ticketProcessing() {
        while (airlineTicketService.hasNextBoardingPass()) {
            securityGateDatabase.registerTicket(airlineTicketService.getNextBoardingPass());
        }
    }
}
