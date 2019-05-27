package network;

import java.time.LocalDateTime;

/**
 * Created by Jaanus on 30.11.16.
 */
public class Message {

    private String message;
    private Person author;
    private int likes;
    private LocalDateTime creationDateTime;

    public Message(String message, Person author) {
        this.message = message;
        this.author = author;
        creationDateTime = LocalDateTime.now();
    }

    public void like() {
        likes++;
    }

    public int getLikes() {
        return likes;
    }
}
