package network;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaanus on 30.11.16.
 */
public class SocialNetwork {
    void startServer() throws InterruptedException {
        Board board = new Board();

        Person p1 = new Person("Tiit", board);
        Person p2 = new Person("Liina", board);
        Person p3 = new Person("Toomas", board);

        Person p4 = new LikingPerson("A", board);
        Person p5 = new LikingPerson("B", board);
        Person p6 = new LikingPerson("C", board);
        Person p7 = new LikingPerson("D", board);
        Person p8 = new LikingPerson("E", board);
        Person p9 = new LikingPerson("F", board);
        Person p10 = new LikingPerson("G", board);

        List<Thread> threads = new ArrayList<>();

        threads.add(new Thread(p1));
        threads.add(new Thread(p2));
        threads.add(new Thread(p3));
        threads.add(new Thread(p4));
        threads.add(new Thread(p5));
        threads.add(new Thread(p6));
        threads.add(new Thread(p7));
        threads.add(new Thread(p8));
        threads.add(new Thread(p9));
        threads.add(new Thread(p10));

        threads.forEach(Thread::start);

        Thread.sleep(7000);

        board.stop();

        System.out.println(board.getMessages().size());
        System.out.println(board.getMessages().stream().mapToInt(Message::getLikes).sum());
    }

    public static void main(String[] args) {
        try {
            new SocialNetwork().startServer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
