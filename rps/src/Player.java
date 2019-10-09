public abstract class Player implements Handler {
    private boolean winStatus;
    private int points;
    protected String lastMove;
    protected String name;

//  Getter/Setter Methods
    boolean isWinStatus() {
        return winStatus;
    }

    int getPoints() {
        return points;
    }

    String getLastMove() {
        return lastMove;
    }

    Player (String name) {
        this.name = name;
    }

    abstract void takeTurn() throws InvalidInputException;
}
