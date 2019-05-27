package airlineservice;

import airport.BoardingPass;
import airport.SasBoardingPass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaanus on 14.09.16.
 */
public class SasAirlineTicketService implements AirlineTicketService {

    private List<BoardingPass> tickets = new ArrayList<>();

    public SasAirlineTicketService() {
        tickets.add(new SasBoardingPass(1, "A", "Z"));
        tickets.add(new SasBoardingPass(2, "B", "Y"));
        tickets.add(new SasBoardingPass(3, "C", "X"));
        tickets.add(new SasBoardingPass(4, "D", "W"));
        tickets.add(new SasBoardingPass(5, "E", "V"));
    }

    @Override
    public boolean hasNextBoardingPass() {
        return !tickets.isEmpty();
    }

    @Override
    public BoardingPass getNextBoardingPass() {
        if (hasNextBoardingPass()) {
            return tickets.remove(0);
        }
        throw new RuntimeException("No boardingpasses left!");
    }
}
