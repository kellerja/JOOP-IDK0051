package airport;

/**
 * Created by Jaanus on 14.09.16.
 */
public interface SecurityGateDatabase {
    public void registerTicket(BoardingPass boardingPass) throws IllegalArgumentException;
}
