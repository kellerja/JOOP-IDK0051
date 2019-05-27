package plane;

/**
 * Created by Jaanus on 26.11.16.
 */
public class Plane implements Runnable {

    private String name;
    private PlaneInstructions instructions;

    public Plane(String name, PlaneInstructions instructions) {
        this.name = name;
        this.instructions = instructions;
    }

    private void fly() {
        while (mustFly()) {
            System.out.println("Plane " + name + " is flying.");
        }
        System.out.println("Plane " + name + " landing.");
    }

    private boolean mustFly() {
        return !instructions.hasLandInstruction(name);
    }

    @Override
    public void run() {
        fly();
    }
}
