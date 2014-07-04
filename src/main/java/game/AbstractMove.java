package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractMove implements Move {
    private final List<Class<? extends Move>> movesICanBeat = new ArrayList();

    AbstractMove(Class<? extends Move>... classesOfMovesICanBeat) {
        Collections.addAll(movesICanBeat, classesOfMovesICanBeat);
    }

    @Override
    public boolean canBeat(Move that) {
        return movesICanBeat.contains(that.getClass());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
