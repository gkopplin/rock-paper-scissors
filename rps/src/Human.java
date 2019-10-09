import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Human extends Player {
    Human(String name) {
        super(name);
    }

    @Override
    void takeTurn() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        String response = null;

        System.out.println(this.name + ", select an option:");
        System.out.println("- Rock");
        System.out.println("- Paper");
        System.out.println("- Scissors");
        response = scanner.nextLine();
        response = response.substring(0, 1).toUpperCase() + response.substring(1);

        List<String> validValues = Arrays.asList("Rock", "Paper", "Scissors");

        if (!validValues.contains(response)) {
            throw new InvalidInputException();
        }

        this.lastMove = response;

    }

    @Override
    public void handleInvalidInput(String response) {
        try {
            this.takeTurn();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
