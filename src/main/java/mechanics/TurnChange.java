package mechanics;
import mechanics.type.*;


public class TurnChange {

    private int currentPlayer = 0;
    private int numberOfPlayers;

    public TurnChange(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int changePlayer(ComparisonStatus comparisonStatus) {

        if (comparisonStatus == ComparisonStatus.TRUE)
            currentPlayer = currentPlayer;
        else if (comparisonStatus == ComparisonStatus.FALSE)
            currentPlayer = currentPlayer + 1;

        if (currentPlayer == numberOfPlayers)
            currentPlayer = 0;

        return currentPlayer;
    }

}
