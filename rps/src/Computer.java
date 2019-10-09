public class Computer extends Player {
    Computer(String name) {
        super(name);
    }

    @Override
    String takeTurn() {
        double randomNum = Math.random();
        if (randomNum <= 0.33) {
            return "Rock";
        } else if (randomNum > 0.33 && randomNum <= 0.66) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }
}
