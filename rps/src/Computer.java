public class Computer extends Player {
    Computer(String name) {
        super(name);
    }

    @Override
    void takeTurn() throws InvalidInputException {
        double randomNum = Math.random();
        if (randomNum <= 0.33) {
            this.lastMove = "Rock";
        } else if (randomNum > 0.33 && randomNum <= 0.66) {
            this.lastMove = "Paper";
        } else {
            this.lastMove = "Scissors";
        }
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
