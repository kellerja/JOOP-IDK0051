package plane;

/**
 * Created by Jaanus on 26.11.16.
 */
public class PlaneController {

    void startShow() {
        PlaneInstructions instructions = new PlaneInstructions();

        Plane p1 = new Plane("1", instructions);
        Plane p2 = new Plane("2", instructions);
        Plane p3 = new Plane("3", instructions);
        Plane p4 = new Plane("4", instructions);
        Plane p5 = new Plane("5", instructions);
        Plane p6 = new Plane("6", instructions);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(p4);
        Thread t5 = new Thread(p5);
        Thread t6 = new Thread(p6);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        instructions.makePlaneLand("3");
        instructions.makePlaneLand("2");
        instructions.makePlaneLand("1");
        instructions.makePlaneLand("4");
        instructions.makePlaneLand("6");
        instructions.makePlaneLand("5");
    }

    public static void main(String[] args) {
        new PlaneController().startShow();
    }

}
