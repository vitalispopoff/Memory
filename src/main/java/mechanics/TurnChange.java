package mechanics;
import mechanics.type.*;


public class TurnChange {

    private static int currentPlayer = 0;
    private static int numberOfPlayers = Player.playerList.size()-1;

    public TurnChange(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public static int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

/*    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }*/ //setNumberOfPlayers - można przez static ArrayList graczy (Player:7)

    public static int changePlayer(ComparisonStatus comparisonStatus) {

        if (comparisonStatus == ComparisonStatus.TRUE)
            currentPlayer = currentPlayer;
        else if (comparisonStatus == ComparisonStatus.FALSE)
            currentPlayer = currentPlayer + 1;

        if (currentPlayer == numberOfPlayers)
            currentPlayer = 0;

        return currentPlayer;
    }

}
