package game;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements Strategy {

    private final Random random = new Random();

    @Override
    public Move getMove(List<Move> possibleMoves) {
        final int randomIndex = Math.abs(random.nextInt()) % possibleMoves.size();
        return possibleMoves.get(randomIndex);
    }
}
