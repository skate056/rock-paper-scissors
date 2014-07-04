package game;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ScissorsTest {
    @Test
    public void shouldReturnTrueForCanBeatPaper() throws Exception {
        assertThat(new Scissors().canBeat(new Paper()), is(true));
    }

    @Test
    public void shouldReturnFalseForCanBeatSelf() throws Exception {
        assertThat(new Scissors().canBeat(new Scissors()), is(false));
    }
}
