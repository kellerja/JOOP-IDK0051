package grinder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jaanus on 7.10.16.
 */
public class CoffeeFlavourAdder {

    private final List<String> acceptedFlavors = Arrays.asList("vanilla", "toffee", "peppermint");

    public void addFlavor(String flavor) {
        if (isNotAcceptedFlavor(flavor)) {
            throw new FlavourNotAvailableException("Selected flavor is not available.");
        }
    }

    private boolean isNotAcceptedFlavor(String flavor) {
        return !acceptedFlavors.contains(flavor);
    }
}
