import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Game implements Handler {
    private boolean gameOver = false;
    private String endGameInfo;
    private Human playerOne = new Human("Player One");
    private Player playerTwo = null;

    String getEndGameInfo() {
        return endGameInfo;
    }

    void numPlayersPrompt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println("1) Type 1 for Player v Computer");
        System.out.println("2) Type 2 for Player v Player");
        String response = scanner.nextLine();
        this.handleInvalidInput(response);          // Wrapper for play game
    }

    private void playGame(String response) throws InvalidInputException {
        this.playerOne.setWinStatus(false);
        this.gameOver = false;

        switch (response) {
            case "1":
                if (this.playerTwo == null || this.playerTwo.getClass().getName().equals("Human")) {
                    this.playerTwo = new Computer("Player Two");
                } else {
                    this.playerTwo.setWinStatus(false);
                }

                break;
            case "2":
                if (this.playerTwo == null || this.playerTwo.getClass().getName().equals("Computer")) {
                    this.playerTwo = new Human("Player Two");
                } else {
                    this.playerTwo.setWinStatus(false);
                }
                break;
            default:
                throw new InvalidInputException();
        }

        while (!this.gameOver) {
            this.handleTurn();
        }
    }

    private void handleTurn() {
        this.playerOne.handleInvalidInput("");   // Wrapper for take turn
        this.playerTwo.handleInvalidInput("");

        if (this.playerOne.lastMove == null || this.playerTwo.lastMove == null) {
            return;
        }

        System.out.println("Player One chose " + this.playerOne.lastMove);
        System.out.println("Player Two chose " + this.playerTwo.lastMove);

        if (this.playerOne.lastMove.equals(this.playerTwo.lastMove)) {
            System.out.println("---- DRAW ----");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }

        if (this.playerOne.lastMove.equals("Rock")) {
            if (this.playerTwo.lastMove.equals("Scissors")) {
                this.endGame(this.playerOne);
            } else {
                this.endGame(this.playerTwo );
            }
        }
        else if (this.playerOne.lastMove.equals("Paper")) {
            if (this.playerTwo.lastMove.equals("Rock")) {
                this.endGame(this.playerOne);
            } else {
                this.endGame(this.playerTwo);
            }
        } else {
            if (this.playerTwo.lastMove.equals("Paper")) {
                this.endGame(this.playerOne);
            } else {
                this.endGame(this.playerTwo);
            }
        }
    }

    private void endGame(Player winner) {
        this.gameOver = true;
        winner.setPoints(winner.getPoints() + 1);
        winner.setWinStatus(true);

        Date date = new Date( );
        SimpleDateFormat format = new SimpleDateFormat ("E MM-dd-yyyy");
        this.endGameInfo = "Date: " + format.format(date) + ", Winner: " + winner.getName();

        System.out.println("---- " + winner.getName() + " won that round! ----");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleInvalidInput(String response) {
        try {
            this.playGame(response);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
