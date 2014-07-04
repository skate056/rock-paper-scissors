package game;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class RockTest {
    @Test
    public void shouldReturnTrueForCanBeatScissors() throws Exception {
        assertThat(new Rock().canBeat(new Scissors()), is(true));
    }

    @Test
    public void shouldReturnFalseForCanBeatSelf() throws Exception {
        assertThat(new Rock().canBeat(new Rock()), is(false));
    }
}
