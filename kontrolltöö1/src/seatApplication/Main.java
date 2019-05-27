package seatApplication;

import seat.Seat;

/**
 * Created by Jaanus on 19.10.16.
 */
public class Main {
    public static void main(String[] args) {
        SeatController seatController = new SeatController();
        Seat s1 = Seat.getInstanceByAttendant("Tiina");
        seatController.addSeat(s1);
        Seat s2 = Seat.getInstanceByAttendant("Tiiu");
        seatController.addSeat(s2);
        Seat s3 = Seat.getInstanceByAttendant("Riina");
        seatController.addSeat(s3);
        Seat s4 = Seat.getInstanceByAttendant("Kalle");
        seatController.addSeat(s4);
        Seat s5 = Seat.getNewInstanceOfSleepSeat();
        seatController.addSeat(s5);
        s1.lowerBackRest();
        s2.lowerBackRest();
        s2.lowerBackRest();
        s5.raiseBackRest();
        s3.lowerBackRest();
        s3.lowerBackRest();
        s3.lowerBackRest();
        s4.lowerBackRest();
        s4.lowerBackRest();
        System.out.println("s1: " + s1.getBackRestAngleInDegrees() +
                "\ns2: " + s2.getBackRestAngleInDegrees() +
                "\ns3: " + s3.getBackRestAngleInDegrees() +
                "\ns4: " + s4.getBackRestAngleInDegrees() +
                "\ns5: " + s5.getBackRestAngleInDegrees());
        seatController.changeAllSeatsUpright();
        System.out.println("s1: " + s1.getBackRestAngleInDegrees() +
                "\ns2: " + s2.getBackRestAngleInDegrees() +
                "\ns3: " + s3.getBackRestAngleInDegrees() +
                "\ns4: " + s4.getBackRestAngleInDegrees() +
                "\ns5: " + s5.getBackRestAngleInDegrees());
    }
}
