import java.util.ArrayList;
import java.util.Scanner;

class Session implements Handler {
    private ArrayList<String> gameHistory = new ArrayList<>();
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
            this.handleInvalidInput(response);         // Wrapper for handling menu input
        }
    }

    private void handleMenuInput(String response) throws InvalidInputException {
        switch (response.toLowerCase()) {
            case "play":
                this.play();
                break;
            case "history":
                if (this.gameHistory == null) {
                    System.out.println("No games have been played yet");
                } else {
                    this.gameHistory.forEach(game -> System.out.println(game));
                }
                break;
            case "quit":
                this.quit = true;
                break;
            default:
                throw new InvalidInputException();
        }
    }

    private void play() {
        Game game = new Game();
        game.numPlayersPrompt();
        this.gameHistory.add(0, game.getEndGameInfo());
    }


    @Override
    public void handleInvalidInput(String response) {
        try {
            this.handleMenuInput(response);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}