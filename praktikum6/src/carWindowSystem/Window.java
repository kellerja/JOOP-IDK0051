package carWindowSystem;

/**
 * Created by Jaanus on 12.10.16.
 */
public class Window {
    public static final int WINDOW_CLOSED_STATUS = 0;
    public static final int WINDOW_OPEN_STATUS = 10;
    public static final double CHANGE_STATUS_MODIFIER = 0.2;
    private String name;
    private short windowOpenStatus;

    Window(String name) {
        this.name = name;
        this.windowOpenStatus = WINDOW_CLOSED_STATUS;
    }

    public void openWindowFully() {
        windowOpenStatus = WINDOW_OPEN_STATUS;
        System.out.println("Aken avati täielikult " + getWindowOpenStatus());
    }

    public void closeWindowFully() {
        windowOpenStatus = WINDOW_CLOSED_STATUS;
        System.out.println("Aken suleti täielikult " + getWindowOpenStatus());
    }

    public void openWindowPartially() {
        windowOpenStatus += WINDOW_OPEN_STATUS * CHANGE_STATUS_MODIFIER;
        if (windowOpenStatus > WINDOW_OPEN_STATUS) {
            openWindowFully();
        } else {
            System.out.println("Aken avati 20% ulatuses " + getWindowOpenStatus());
        }
    }

    public void closeWindowPartially() {
        windowOpenStatus -= WINDOW_OPEN_STATUS * CHANGE_STATUS_MODIFIER;
        if (windowOpenStatus < WINDOW_CLOSED_STATUS) {
            closeWindowFully();
        } else {
            System.out.println("Aken suleti 20% ulatuses" + getWindowOpenStatus());
        }
    }

    public short getWindowOpenStatus() {
        return windowOpenStatus;
    }

    @Override
    public String toString() {
        return name + " " + windowOpenStatus;
    }
}
