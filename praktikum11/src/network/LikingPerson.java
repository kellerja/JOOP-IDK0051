package network;

/**
 * Created by Jaanus on 30.11.16.
 */
public class LikingPerson extends Person {
    public LikingPerson(String name, Board board) {
        super(name, board);
    }

    @Override
    public void act() throws InterruptedException {
        getBoard().latestMessage().like();
    }
}
