package game;

public interface Player {
    Move play();

    void notifyResult(Result result);
}
