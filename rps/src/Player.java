public abstract class Player {
    private boolean winStatus;
    private int points;
    private String lastMove;

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

    abstract String takeTurn();
}
