package stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Jaanus on 2.11.16.
 */
public class Stream {
    private static final String file = "stream.txt";
    void streamChangeExample() {
        System.out.println("normaalne");
        PrintStream printStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            printStream = new PrintStream(fos);
            System.setOut(printStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("failis on");
        if (printStream != null) {
            printStream.close();
        }
    }

    public static void main(String[] args) {
        new Stream().streamChangeExample();
    }
}
