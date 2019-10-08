import java.util.Scanner;

public class Game {
    private boolean gameOver = false;

    void numPlayersPrompt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println("1) Type 1 for Player v Computer");
        System.out.println("2) Type 2 for Player v Player");
        String response = scanner.nextLine();
        this.playGame(response);
    }

    void playGame(String response) {
        Human playerOne = new Human();
        Player playerTwo = null;

        switch (response) {
            case "1":
                playerTwo = new Computer();
            case "2":
                playerTwo = new Human();
            default:
//                todo
        }

        while (!this.gameOver) {
            this.handleTurn( playerOne, playerTwo);
        }
    }

    void handleTurn(Player playerOne, Player playerTwo) {
        String playerOneMove = playerOne.takeTurn();
        String playerTwoMove = playerTwo.takeTurn();
        System.out.println("Player One chose " + playerOneMove);
        System.out.println("Player Two chose " + playerTwoMove);

        if (playerOneMove.equals(playerTwoMove)) {
            return;
        }

        if (playerOneMove.equals("Rock")) {
            if (playerTwoMove.equals("Scissors")) {
                this.endGame("Player One");
            } else {
                this.endGame("Player Two");
            }
        }
        else if (playerOneMove.equals("Paper")) {
            if (playerTwoMove.equals("Rock")) {
                this.endGame("Player One");
            } else {
                this.endGame("Player Two");
            }
        } else {
            if (playerTwoMove.equals("Paper")) {
                this.endGame("Player One");
            } else {
                this.endGame("Player Two");
            }
        }


    }

    void endGame(String winner) {
        this.gameOver = true;
        System.out.println(winner + " won that round!");
    }

}
