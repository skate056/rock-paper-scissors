package game;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComputerPlayerTest {

    private final Rock rock = new Rock();
    private final Paper paper = new Paper();
    private final Scissors scissors = new Scissors();
    private final List<Move> allowedMoves = Lists.<Move>newArrayList(rock, paper, scissors);

    @Mock
    private Strategy strategy;

    @Mock
    private Move strategyMove;

    private ComputerPlayer computerPlayer;

    @Test
    public void shouldCallStrategyOnPlay(){
        computerPlayer = new ComputerPlayer(strategy, rock, paper, scissors);
        given(strategy.getMove(anyListOf(Move.class))).willReturn(strategyMove);

        Move move = computerPlayer.play();

        verify(strategy).getMove(anyListOf(Move.class));
        assertThat(move, is(strategyMove));
    }
}
