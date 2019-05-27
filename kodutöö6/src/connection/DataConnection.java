package connection;

import compressor.Compressor;

import java.io.*;

/**
 * Created by Jaanus on 28.10.16.
 */
public class DataConnection {
    private Compressor compressor;
    private String message;

    public DataConnection(Compressor compressor) {
        this.compressor = compressor;
    }

    public void addMessage(String message) {
        if (this.message == null) {
            this.message = message;
        } else {
            this.message += ";" + message;
        }
    }

    private String compressMessage(String message) {
        if (compressor == null) {
            return message;
        }
        return compressor.compress(message);
    }

    public void sendMessage() {
        /*Ei saanud aru kas fail tuli igakord üle kirjutada või tuli faili lõppu lisada sõnum.*/
        boolean append = false;
        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("package.txt", append), "utf-8"))) {
            writer.write(compressMessage(message));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
