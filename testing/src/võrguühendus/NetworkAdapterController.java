package võrguühendus;

import java.util.Optional;

/**
 * Created by Jaanus on 18.10.16.
 */
public class NetworkAdapterController {
    public static Optional<NetworkAdapter> of(String type) {
        if (type.equals("LAN")) {
            return Optional.of(new NetworkAdapter());
        } else if (type.equals("WIFI")) {
            return Optional.of(new WifiAdapter());
        } else if (type.equals("4G")) {
            return Optional.of(new FourGAdapter());
        }
        return Optional.empty();
    }
}
