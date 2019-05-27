package carWindowSystem;

import java.util.Optional;

/**
 * Created by Jaanus on 12.10.16.
 */
public class WindowController {
    public static Window getInstance(String name) {
        if (isFrontWindow(name)) {
            return new Window(name);
        } else {
            return new RearWindow(name);
        }
    }

    private static boolean isFrontWindow(String name) {
        return name.equals("A") || name.equals("B");
    }

    public static Optional<Window> getWindowsInstanceOfTwoDooredCar(String name) {
        if (isFrontWindow(name)) {
            return Optional.of(new Window(name));
        }
        return Optional.empty();
    }
}
