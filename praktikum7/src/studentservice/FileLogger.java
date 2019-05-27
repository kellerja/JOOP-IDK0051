package studentservice;

import java.io.*;

/**
 * Created by Jaanus on 2.11.16.
 */
public class FileLogger extends MyLogger {
    private static final String file = "log.txt";
    private PrintStream logStream;

    public FileLogger() {
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            logStream = new PrintStream(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String data) {
        logStream.println(data);
    }
}
