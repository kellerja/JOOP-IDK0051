package airlineservice;

import airport.BoardingPass;

/**
 * Created by Jaanus on 14.09.16.
 */
public interface AirlineTicketService {
    public boolean hasNextBoardingPass();
    public BoardingPass getNextBoardingPass();
}
