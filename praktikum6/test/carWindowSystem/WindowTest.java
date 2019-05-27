package carWindowSystem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaanus on 12.10.16.
 */
public class WindowTest {
    List<Window> windows;
    @Before
    public void before() {
        windows = new ArrayList<>();
        windows.add(WindowController.getInstance("A"));
        windows.add(WindowController.getInstance("B"));
        windows.add(WindowController.getInstance("C"));
        windows.add(WindowController.getInstance("D"));
    }

    @Test
    public void getWindowOpen() {
        assertEquals(0, windows.get(0).getWindowOpenStatus());
    }

    @Test
    public void openWindowFully() {
        windows.get(0).openWindowFully();
        assertEquals(10, windows.get(0).getWindowOpenStatus());
    }

    @Test
    public void openWindowFullyAndCloseWindowFully() {
        windows.get(0).openWindowFully();
        windows.get(0).closeWindowFully();
        assertEquals(0, windows.get(0).getWindowOpenStatus());
    }

    @Test
    public void openWindowByFifth() {
        windows.get(0).openWindowPartially();
        assertEquals(2, windows.get(0).getWindowOpenStatus());
    }

    @Test
    public void openWindowByFifthTwice() {
        windows.get(0).openWindowPartially();
        windows.get(0).openWindowPartially();
        assertEquals(4, windows.get(0).getWindowOpenStatus());
    }

    @Test
    public void openWindowFullyAndCloseByFifth() {
        windows.get(0).openWindowFully();
        windows.get(0).closeWindowPartially();
        assertEquals(8, windows.get(0).getWindowOpenStatus());
    }

    @Test
    public void windowControllerReturnsWindows() {
        Window window = WindowController.getInstance("A");
        assertEquals(Window.class, window.getClass());
    }

    @Test
    public void windowControllerReturnsRearWindow() {
        Window window = WindowController.getInstance("C");
        assertEquals(RearWindow.class, window.getClass());
    }

    @Test
    public void openOpenedWindowPartially() {
        windows.get(0).openWindowFully();
        windows.get(0).openWindowPartially();
        assertEquals(10, windows.get(0).getWindowOpenStatus());
    }

    @Test
    public void closeClosedWindowPartially() {
        windows.get(0).closeWindowPartially();
        assertEquals(0, windows.get(0).getWindowOpenStatus());
    }

    @Test
    public void windowToString() {
        assertEquals("A 0", windows.get(0).toString());
    }

    @Test
    public void rearWindowLockAndOpenWindow() {
        RearWindow rearWindow = (RearWindow) windows.get(2);
        RearWindow.lockWindow();
        rearWindow.openWindowFully();
        assertEquals(0, rearWindow.getWindowOpenStatus());
    }

    @Test
    public void rearWindowLockOpenWindowFullyUnlockOpenWindowPartially() {
        RearWindow rearWindow = (RearWindow) windows.get(2);
        RearWindow.lockWindow();
        rearWindow.openWindowFully();
        RearWindow.unlockWindow();
        rearWindow.openWindowPartially();
        assertEquals(2, rearWindow.getWindowOpenStatus());
    }

    @Test
    public void testCollectionIterate() {
        //TODO make every part into it's own test!
        windows.forEach(window -> {
            RearWindow.unlockWindow();
            window.openWindowPartially();
            window.openWindowFully();
            window.openWindowPartially();
            window.closeWindowPartially();
            window.closeWindowFully();
            window.closeWindowPartially();
            window.openWindowPartially();
            RearWindow.lockWindow();
            window.openWindowPartially();
            window.closeWindowFully();
        });
    }
}
