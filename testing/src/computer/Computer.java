package computer;
import võrguühendus.FourGAdapter;
import võrguühendus.NetworkAdapter;
import võrguühendus.NetworkAdapterController;
import võrguühendus.WifiAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jaanus on 18.10.16.
 */
public class Computer {
    public static final String IP_TO_PING = "192.168.0.1";
    private NetworkAdapter networkAdapter;
    private WifiAdapter wifiAdapter;
    private FourGAdapter fourGAdapter;

    public Computer(int serial) {
        InitializeLANAdapter();
        initializeWifiAdapter();
        if (is4GCapable(serial)) {
            initialize4GAdapter();
        }
    }

    private boolean is4GCapable(int serial) {
        return serial >= 3700;
    }

    private void initialize4GAdapter() {
        Optional<NetworkAdapter> fourGAdapterOptional = NetworkAdapterController.of("4G");
        if (fourGAdapterOptional.isPresent()) {
            fourGAdapter = (FourGAdapter) fourGAdapterOptional.get();
        }
    }

    private void initializeWifiAdapter() {
        Optional<NetworkAdapter> wifiAdapterOptional = NetworkAdapterController.of("WIFI");
        if (wifiAdapterOptional.isPresent()) {
            wifiAdapter = (WifiAdapter) wifiAdapterOptional.get();
        }
    }

    private void InitializeLANAdapter() {
        Optional<NetworkAdapter> networkAdapterOptional = NetworkAdapterController.of("LAN");
        if (networkAdapterOptional.isPresent()) {
            networkAdapter = networkAdapterOptional.get();
        }
    }

    public Optional<NetworkAdapter> getFourGAdapter() {
        return Optional.ofNullable(fourGAdapter);
    }

    public Optional<NetworkAdapter> getWifiAdapter() {
        return Optional.ofNullable(wifiAdapter);
    }

    public Optional<NetworkAdapter> getNetworkAdapter() {
        return Optional.ofNullable(networkAdapter);
    }

    public void shutDown() {
        List<Optional<NetworkAdapter>> networkAdapters = new ArrayList<>();
        networkAdapters.add(getNetworkAdapter());
        networkAdapters.add(getWifiAdapter());
        networkAdapters.add(getFourGAdapter());
        networkAdapters.forEach(adapterOptional -> {
            if (adapterOptional.isPresent()) {
                NetworkAdapter adapter = adapterOptional.get();
                System.out.println(adapter);
                adapter.ping(IP_TO_PING);
                adapter.connect();
                adapter.ping(IP_TO_PING);
                System.out.println(adapter);
                adapter.disconnect();
            }
        });
    }

    public static void main(String[] args) {
        Computer c = new Computer(3701);
        c.shutDown();
        System.out.println();
        c = new Computer(3699);
        c.shutDown();
    }
}
