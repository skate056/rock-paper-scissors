package game;

public class Game {
    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Result playHand() {
        Move move1 = player1.play();
        Move move2 = player2.play();
        Result result = calculateWinner(move1, move2);
        notifyResult(result);
        return result;
    }

    private Result calculateWinner(Move move1, Move move2) {
        if (move1.canBeat(move2)) {
            return new Result(player1);
        } else if (move2.canBeat(move1)) {
            return new Result(player2);
        }
        return Result.TIE;
    }

    private void notifyResult(Result result) {
        player1.notifyResult(result);
        player2.notifyResult(result);
    }
}
