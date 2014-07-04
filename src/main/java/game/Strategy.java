package game;

import java.util.List;

public interface Strategy {
    Move getMove(List<Move> moves);
}
