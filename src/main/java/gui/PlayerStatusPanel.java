package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerStatusPanel extends TemporalParent {

    private static ArrayList<PlayerStatusPanel> playerRegistry = new ArrayList<>();
    private static int playerNumberCounter = 0;
    public static int currentPlayerIndex=0;

//    private static int indexOfPlayerOnTheMove;
//    private static int[] playerScoreRegistry;


    //    private int playerIndividualScore;
//    private JLabel playerScoreLabel;
    private JLabel playerPointer;
    private int playerIndexNumber;
    private int playerScoreValue = 0;
    private String scoreValueGraphicUrl = "src\\main\\resources\\infoPanel\\" + playerScoreValue + ".png";

    PlayerStatusPanel(int numberOfPlayers) {
        super();
        this.playerIndexNumber = playerNumberCounter++;
        playerRegistry.add(playerIndexNumber, this);

//        *     LOCAL DIMENSION VALUES

        int locationVerticalComponent = playerStatusPanelBounds[1] + (playerIndexNumber * playerStatusPanelBounds[3] / numberOfPlayers);
        int[] pointerBounds = {
                0,
                0,
                playerStatusPanelBounds[2] >> 2,
                (playerStatusPanelBounds[3] / numberOfPlayers) >> 1
        };
        int pointerGraphicSize = Math.min(pointerBounds[2], pointerBounds[3]);

//        *     PANEL PROPERTIES

        {
        setLayout(null);
        setBounds(
                playerStatusPanelBounds[0],
                locationVerticalComponent,
                playerStatusPanelBounds[2],
                playerStatusPanelBounds[3] / numberOfPlayers
        );
}

//        *     POINTER

        /*JLabel */playerPointer = new JLabel();
        {
        playerPointer.setBounds(
                0, 0,
                pointerBounds[2],
                pointerBounds[3]
        );
        Image PointerIcon = new ImageIcon("src\\main\\resources\\infoPanel\\pointer.png")
                .getImage().getScaledInstance(
                        pointerGraphicSize,
                        pointerGraphicSize,
                        Image.SCALE_SMOOTH);
        playerPointer.setIcon(new ImageIcon(PointerIcon));
        playerPointer.setVisible(playerIndexNumber==0);
        }
        add(playerPointer);

//        *     NAME

        JLabel playerName = new JLabel();
        {
        playerName.setBounds(
                pointerBounds[2],
                0,
                (playerStatusPanelBounds[2] - (playerStatusPanelBounds[2] >> 2)),
                pointerBounds[3]
        );
        Image playerNameGraphic = new ImageIcon("src\\main\\resources\\infoPanel\\player"+playerIndexNumber+".png")
                .getImage().getScaledInstance(
                        (playerStatusPanelBounds[2] - (playerStatusPanelBounds[2] >> 2)),
                        pointerBounds[3],
                        Image.SCALE_SMOOTH
                );
        playerName.setIcon(new ImageIcon(playerNameGraphic));
        }
        add(playerName);

//        *     SCORES

        JLabel playerScoreValue = new JLabel();
        {
        playerScoreValue.setBounds(
                playerStatusPanelBounds[2] >> 2,
                (playerStatusPanelBounds[3] / numberOfPlayers) >> 1,
                playerStatusPanelBounds[2] >> 1,
                ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers
        );
        Image playerScoreIcon = new ImageIcon(scoreValueGraphicUrl)
                .getImage().getScaledInstance(
                        ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers,
                        ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers,
                        Image.SCALE_SMOOTH);
        playerScoreValue.setIcon(new ImageIcon(playerScoreIcon));
        }
        add(playerScoreValue);
    }

    public static int setNextPlayer(){
        currentPlayerIndex=(++currentPlayerIndex)%MainFrame.numberOfPlayers;

        return currentPlayerIndex;
    }

    public static void refreshPointers(){
        for (PlayerStatusPanel pointer: playerRegistry) {
            pointer.playerPointer.setVisible(pointer.playerIndexNumber==currentPlayerIndex);
        }
    }

    public int getPlayerIndexNumber() {
        return playerIndexNumber;
    }

    public int getPlayerScoreValue() {
        return playerScoreValue;
    }

    public void setPlayerScoreValue(int playerScoreValue) {
        this.playerScoreValue = playerScoreValue;
    }

    public int incrementPlayerScoreValue() {
        return ++playerScoreValue;
    }

    public String getScoreValueGraphicUrl() {
        return scoreValueGraphicUrl;
    }

    public void setScoreValueGraphicUrl() {
        this.scoreValueGraphicUrl = "src\\main\\resources\\infoPanel\\" + playerScoreValue + ".png";
    }
}
