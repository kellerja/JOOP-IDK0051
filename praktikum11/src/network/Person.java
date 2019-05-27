package network;

/**
 * Created by Jaanus on 30.11.16.
 */
public class Person implements Runnable {

    private String name;
    private Board board;

    public Person(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public void act() throws InterruptedException {
        getBoard().addMessage(new Message("message", this));
        Thread.sleep(20);
    }

    @Override
    public void run() {
        try {
            while (board.isActive()) {
                act();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Board getBoard() {
        return board;
    }
}
