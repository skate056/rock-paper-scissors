package game;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import com.google.common.collect.Lists;
import org.junit.Test;

public class RandomStrategyTest {
    private final Rock rock = new Rock();
    private final Paper paper = new Paper();
    private final Scissors scissors = new Scissors();
    private final List<Move> allowedMoves = Lists.<Move>newArrayList(rock, paper, scissors);

    @Test
    public void shouldReturnAValidMove(){
        RandomStrategy strategy = new RandomStrategy();
        Move move = strategy.getMove(allowedMoves);

        assertThat(allowedMoves, hasItem(move));
    }
}
