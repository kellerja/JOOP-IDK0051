package võrguühendus;

/**
 * Created by Jaanus on 18.10.16.
 */
public class WifiAdapter extends NetworkAdapter {

    public int getNetworkStrength() {
        return (int) Math.floor(Math.random() * 5) + 1;
    }

    @Override
    public void ping(String IP) {
        if (isConnected()) {
            System.out.println("Võrgusignaali tugevus: " + getNetworkStrength());
            pingCore(IP);
        } else {
            throw new NoNetworkConnectionException();
        }
    }
}
