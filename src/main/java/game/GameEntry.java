package game;

public class GameEntry {
    public static void main(String[] args) {
        Strategy strategy = new RandomStrategy();
        new Game(
                new HumanPlayer(),
                new ComputerPlayer(strategy, new Rock(), new Scissors(), new Paper()))
                .playHand();
    }
}
