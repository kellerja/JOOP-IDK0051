package carWindowSystem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jaanus on 12.10.16.
 */
public class TwoDoorerTest {
    private List<Optional<Window>> windows;
    @Before
    public void setUp() {
        windows = new ArrayList<>();
        windows.add(WindowController.getWindowsInstanceOfTwoDooredCar("A"));
        windows.add(WindowController.getWindowsInstanceOfTwoDooredCar("B"));
        windows.add(WindowController.getWindowsInstanceOfTwoDooredCar("C"));
        windows.add(WindowController.getWindowsInstanceOfTwoDooredCar("D"));
    }

    @Test
    public void windowControllerReturnsEmptyOptionalForRearWindowAndWindowObjectForFrontWindow() {
        windows.forEach(window -> {
            if (window.isPresent()) {
                assertEquals(Window.class, window.get().getClass());
            } else {
                assertEquals(Optional.empty(), window);
            }
        });
    }
}
