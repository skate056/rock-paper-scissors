package game;

import java.util.Scanner;

public class HumanPlayer implements Player {
    @Override
    public Move play() {
        Scanner scanner = new Scanner(System.in);
        final String moveName = scanner.next();
        return createMoveFromName(moveName);
    }

    private Move createMoveFromName(String moveName) {
        switch (moveName) {
            case "rock":
            case "ROCK":
            case "Rock":
                return new Rock();
            case "paper":
            case "PAPER":
            case "Paper":
                return new Paper();
            case "scissor":
            case "SCISSOR":
            case "Scissors":
                return new Scissors();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void notifyResult(Result result) {
        System.out.println("--Result--");
        System.out.printf("Is A Tie: %s\n", result.isTie());
        System.out.printf("Winner: %s\n", result.getWinner());
    }
}
