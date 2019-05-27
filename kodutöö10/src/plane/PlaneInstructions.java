package plane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaanus on 26.11.16.
 */
public class PlaneInstructions {

    private List<String> planesThatLand;

    public PlaneInstructions() {
        planesThatLand = new ArrayList<>();
    }

    public synchronized boolean hasLandInstruction(String planeName) {
        return planesThatLand.remove(planeName);
    }

    public void makePlaneLand(String name) {
        planesThatLand.add(name);
    }

}
