package game;

public class Result {
    private final Player winner;
    private final boolean isATie;

    public static Result TIE = new Result(true);

    public Result(Player winner) {
        this.winner = winner;
        this.isATie = false;
    }

    private Result(boolean isATie) {
        this.winner = null;
        this.isATie = isATie;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isTie() {
        return isATie;
    }
}
