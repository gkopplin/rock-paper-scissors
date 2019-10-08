import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Human extends Player {
    @Override
    String takeTurn() {
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);
        String response = null; 

        while (!validInput) {
            System.out.println("Select an option:");
            System.out.println("- Rock");
            System.out.println("- Paper");
            System.out.println("- Scissors");
            response = scanner.nextLine();
            response = response.substring(0, 1).toUpperCase() + response.substring(1);

            List<String> validValues = Arrays.asList("Rock", "Paper", "Scissors");

            if (validValues.contains(response)) {
                validInput = true;
            }

        }

        return response;

    }
}
