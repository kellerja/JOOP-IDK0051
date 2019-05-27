package network;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaanus on 30.11.16.
 */
public class Board {

    private final List<Message> messages = new ArrayList<>();

    private volatile boolean isActive = true;

    public int numberOfMessages() {
        synchronized (messages) {
            return messages.size();
        }
    }

    public Message latestMessage() throws InterruptedException {
        synchronized (messages) {
            while (isActive() && (messages.size() == 0 || messages.get(numberOfMessages() - 1).getLikes() > 0)) {
                messages.wait();
            }
            return messages.get(numberOfMessages() - 1);
        }
    }

    public void addMessage(Message message) {
        synchronized (messages) {
            messages.add(message);
            messages.notifyAll();
        }
    }

    public List<Message> getMessages() {
        return messages;
    }

    public boolean isActive() {
        return isActive;
    }

    public void stop() {
        isActive = false;
        synchronized (messages) {
            messages.notifyAll();
        }
    }
}
