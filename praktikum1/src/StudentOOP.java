class StudentOOP {

    private String name;
    private int points = 0;

    public StudentOOP(String name) {
        this.name = name;
    }

    public void addPoints(int pointsToAdd) {
        this.points += pointsToAdd;
    }

    public int getPoints() {
        return points;
    }
}