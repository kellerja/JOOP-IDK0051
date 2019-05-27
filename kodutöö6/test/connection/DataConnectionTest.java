package connection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import compressor.RemoveVowels;
import org.junit.Test;
import org.junit.Before;

/**
 * Created by Jaanus on 28.10.16.
 */
public class DataConnectionTest {
    private RemoveVowels compressor;
    private DataConnection dataConnection;

    @Before
    public void setUp() {
        compressor = mock(RemoveVowels.class);
        dataConnection = new DataConnection(compressor);
    }

    @Test
    public void testDataConnectionCallsCompressorsCompressMethod() {
        String message = "Nägin ahvi!;Moskiito hammustas kolleegi!";
        dataConnection.addMessage("Nägin ahvi!");
        dataConnection.addMessage("Moskiito hammustas kolleegi!");
        dataConnection.sendMessage();
        verify(compressor).compress(message);
    }
}
