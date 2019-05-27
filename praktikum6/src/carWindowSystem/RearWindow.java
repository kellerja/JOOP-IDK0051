package carWindowSystem;

/**
 * Created by Jaanus on 12.10.16.
 */
public class RearWindow extends Window {
    private static boolean canChangeState;

    RearWindow(String location) {
        super(location);
        canChangeState = true;
    }

    public static void lockWindow() {
        canChangeState = false;
    }

    public static void unlockWindow() {
        canChangeState = true;
    }

    @Override
    public void openWindowFully() {
        if (canChangeState) {
            super.openWindowFully();
        } else {
            printUnableToOpenMessage();
        }
    }

    @Override
    public void openWindowPartially() {
        if (canChangeState) {
            super.openWindowPartially();
        } else {
            printUnableToOpenMessage();
        }
    }

    private void printUnableToOpenMessage() {
        System.out.println("Akna avamine on hetkel blokeeritud");
    }
}
