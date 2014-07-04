package game;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerPlayer implements Player {
    private final List<Move> possibleMoves = new ArrayList();
    private final Strategy strategy;

    public ComputerPlayer(Strategy strategy, Move... moves) {
        this.strategy = checkNotNull(strategy, "strategy");
        Collections.addAll(possibleMoves, moves);
    }

    @Override
    public Move play() {
        return strategy.getMove(possibleMoves);
    }

    @Override
    public void notifyResult(Result result) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
