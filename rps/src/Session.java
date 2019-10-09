import java.util.ArrayList;
import java.util.Scanner;

class Session {
    private ArrayList<String> gameHistory;
    private boolean quit;

    private static void displayMenu() {
        System.out.println("*************************");
        System.out.println(" ROCK - PAPER - SCISSORS ");
        System.out.println("*************************");
        System.out.println("");
        System.out.println("Type \'play\' to start a new game");
        System.out.println("Type \'history\' to view match history");
        System.out.println("Type \'quit\' to exit");
    }

    void startSession() {
        Scanner scanner = new Scanner(System.in);
        while(!this.quit) {
            Session.displayMenu();
            String response = scanner.nextLine();
            this.handleMenuInput(response);
        }
    }

    private void handleMenuInput(String response) {
        switch (response) {
            case "play":
                this.play();
                break;
            case "history":
                System.out.println(this.gameHistory);
                break;
            case "quit":
                this.quit = true;
                break;
            default:
//            todo
                break;
        }
    }

    private void play() {
        Game game = new Game();
        game.numPlayersPrompt();
    }


}