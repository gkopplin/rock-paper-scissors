public abstract class Player implements Handler {
    private boolean winStatus;
    private int points;
    protected String lastMove;
    protected String name;

//  Getter/Setter Methods
    boolean getWinStatus() {
        return winStatus;
    }

    int getPoints() {
        return points;
    }

    String getLastMove() {
        return lastMove;
    }

    public String getName() {
        return name;
    }

    public void setWinStatus(boolean winStatus) {
        this.winStatus = winStatus;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    Player (String name) {
        this.name = name;
    }

    abstract void takeTurn() throws InvalidInputException;
}
