package game;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class PaperTest {
    @Test
    public void shouldReturnTrueForCanBeatRock() throws Exception {
        assertThat(new Paper().canBeat(new Rock()), is(true));
    }

    @Test
    public void shouldReturnFalseForCanBeatSelf() throws Exception {
        assertThat(new Paper().canBeat(new Paper()), is(false));
    }
}
