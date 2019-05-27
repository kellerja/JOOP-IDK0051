package võrguühendus;

/**
 * Created by Jaanus on 18.10.16.
 */
public class NetworkAdapter {
    private static final String CONNECTION_NAME = "LAN";
    private boolean connectionStatus;

    private int numberOfPingsCompleted = 0;

    public void connect() {
        connectionStatus = true;
    }

    public void disconnect() {
        connectionStatus = false;
    }

    public boolean isConnected() {
        return connectionStatus;
    }

    public void ping(String IP) {
        if (isConnected()) {
            pingCore(IP);
        } else {
            throw new NoNetworkConnectionException();
        }
    }

    void pingCore(String IP) {
        System.out.println("Saadeti päring aadressile " + IP);
        numberOfPingsCompleted++;
    }

    static String getConnectionName() {
        return CONNECTION_NAME;
    }

    int getNumberOfPingsCompleted() {
        return numberOfPingsCompleted;
    }

    @Override
    public String toString() {
        return "Ühenduse tüüp: " + getConnectionName() +
                "\nÜhenduse staatus: " + isConnected() +
                "\nPäringuid saadetud: " + getNumberOfPingsCompleted();
    }
}
