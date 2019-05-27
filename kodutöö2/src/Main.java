import doorlock.ElectronicLock;

/**
 * Created by Jaanus on 16.09.16.
 */
public class Main {
    public static void main(String[] args) {
        ElectronicLock door1 = new ElectronicLock("REAAL");
        ElectronicLock door2 = new ElectronicLock("KARLDA");
        ElectronicLock door3 = new ElectronicLock("KARDLA");
        ElectronicLock door4 = new ElectronicLock("KAPAK");
        ElectronicLock door5 = new ElectronicLock("NOO");
        ElectronicLock door6 = new ElectronicLock("NOO");
        door1.openDoor("511111111111111111111");
        door2.openDoor("4111111111111111111");
        door3.openDoor("622222222223333333");
        door4.openDoor("522222222222222222");
        door5.openDoor("523233333333333333");
        door6.openDoor("11111111111111111115");
    }
}
