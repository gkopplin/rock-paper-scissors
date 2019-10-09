import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Game implements Handler {
    private boolean gameOver = false;
    private String endGameInfo;

    public String getEndGameInfo() {
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
        Human playerOne = new Human("Player One");
        Player playerTwo = null;

        switch (response) {
            case "1":
                playerTwo = new Computer("Player Two");
                break;
            case "2":
                playerTwo = new Human("Player Two");
                break;
            default:
                throw new InvalidInputException();
        }

        while (!this.gameOver) {
            this.handleTurn( playerOne, playerTwo);
        }
    }

    private void handleTurn(Player playerOne, Player playerTwo) {
        playerOne.handleInvalidInput("");   // Wrapper for take turn
        playerTwo.handleInvalidInput("");

        if (playerOne.lastMove == null || playerTwo.lastMove == null) {
            return;
        }

        System.out.println("Player One chose " + playerOne.lastMove);
        System.out.println("Player Two chose " + playerTwo.lastMove);

        if (playerOne.lastMove.equals(playerTwo.lastMove)) {
            System.out.println("---- DRAW ----");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }

        if (playerOne.lastMove.equals("Rock")) {
            if (playerTwo.lastMove.equals("Scissors")) {
                this.endGame("Player One");
            } else {
                this.endGame("Player Two");
            }
        }
        else if (playerOne.lastMove.equals("Paper")) {
            if (playerTwo.lastMove.equals("Rock")) {
                this.endGame("Player One");
            } else {
                this.endGame("Player Two");
            }
        } else {
            if (playerTwo.lastMove.equals("Paper")) {
                this.endGame("Player One");
            } else {
                this.endGame("Player Two");
            }
        }


    }

    private void endGame(String winner) {
        this.gameOver = true;
        Date date = new Date( );
        SimpleDateFormat format = new SimpleDateFormat ("E MM-dd-yyyy");
        this.endGameInfo = "Date: " + format.format(date) + ", Winner: " + winner;

        System.out.println("---- " + winner + " won that round! ----");
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
