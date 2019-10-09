public abstract class Player {
    private boolean winStatus;
    private int points;
    private String lastMove;
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

    abstract String takeTurn();
}
