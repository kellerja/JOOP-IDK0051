package train.user;

import train.train.Train;

/**
 * Created by Jaanus on 4.01.17.
 */
public class Stowaway extends Traveler {

    private Train memory;

    public Stowaway(String name) {
        super(name);
        memory = null;
    }

    @Override
    public void setTicket(Train ticket) {
        memory = ticket;
    }

    @Override
    public boolean isLastTrain(Train train) {
        return train.equals(memory);
    }
}
