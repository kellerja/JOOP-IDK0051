class StudentMain {
    public static void main(String[] args) {
        System.out.println("1:");
        System.out.println("See on staatiline meetod, see ei ole objekt. Uhtlasi on see main meetod.");
        System.out.println("\n2:");
        StudentProc.addStudent("Toomas");
        StudentProc.addStudent("Mari");
        StudentProc.addStudent("Karl");
        StudentProc.addPoints("Toomas", 7);
        StudentProc.addPoints("Mari", 9);
        StudentProc.addPoints("Karl", 8);
        System.out.println("Toomas: " + StudentProc.getPoints("Toomas") + "\nMari: " + StudentProc.getPoints("Mari") + "\nKarl: " + StudentProc.getPoints("Karl"));
        System.out.println("\n3:");
        StudentOOP mari = new StudentOOP("Mari");
        mari.addPoints(9);
        StudentOOP toomas = new StudentOOP("Toomas");
        toomas.addPoints(7);
        StudentOOP karl = new StudentOOP("Karl");
        karl.addPoints(8);
        System.out.println("Mari = " + mari.getPoints());
        System.out.println("\n4:");
        StudentProc.addStudent("Mari");
        StudentProc.addPoints("Mari", 12);
        System.out.println("Uus Mari Static: " + StudentProc.getPoints("Mari") + " vana Mari " + StudentProc.getPoints("Mari"));
        StudentOOP mari2 = new StudentOOP("Mari");
        mari2.addPoints(12);
        System.out.println("Uus Mari Object: " + mari2.getPoints() + " vana Mari " + mari.getPoints());
    }
}
