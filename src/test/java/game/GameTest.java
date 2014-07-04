package game;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    @Mock
    private Player player1;
    @Mock
    private Player player2;

    private final Move rock = new Rock();
    private final Move paper = new Paper();

    private Game game;

    @Before
    public void setUp() {
        game = new Game(player1, player2);
    }

    @Test
    public void shouldGetMoveFromEachPlayer() throws Exception {
        given(player1.play()).willReturn(paper);
        given(player2.play()).willReturn(rock);

        game.playHand();

        verify(player1).play();
        verify(player2).play();
    }

    @Test
    public void shouldReturnP1AsWinnerIfMoveOfP1BeatsMoveOfP2() throws Exception {
        given(player1.play()).willReturn(paper);
        given(player2.play()).willReturn(rock);

        Result result = game.playHand();

        verify(player1).play();
        verify(player2).play();
        verify(player1).notifyResult(result);
        verify(player2).notifyResult(result);
        assertThat(result.isTie(), is(false));
        assertThat(result.getWinner(), is(player1));
    }

    @Test
    public void shouldReturnP2AsWinnerIfMoveOfP1DoesNotBeatMoveOfP2() throws Exception {
        given(player1.play()).willReturn(rock);
        given(player2.play()).willReturn(paper);

        Result result = game.playHand();

        verify(player1).play();
        verify(player2).play();
        assertThat(result.isTie(), is(false));
        assertThat(result.getWinner(), is(player2));
    }

    @Test
    public void shouldReturnIsTieAsTrueIfBothHaveSameMove() throws Exception {
        given(player1.play()).willReturn(rock);
        given(player2.play()).willReturn(rock);

        Result result = game.playHand();

        verify(player1).play();
        verify(player2).play();
        assertThat(result.isTie(), is(true));
        assertThat(result.getWinner(), is(nullValue()));
    }
}
