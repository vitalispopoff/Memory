package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//import static gui.TemporalParent.numberOfPlayers;

/*public*/ class PlayerStatusPanel extends TemporalParent {

    private static ArrayList<PlayerStatusPanel> playerRegistry = new ArrayList<>();
    private static int playerNumberCounter = 0;
    public static int currentPlayerIndex = 0;

//    private static int indexOfPlayerOnTheMove;
//    private static int[] playerScoreRegistry;


    //    private int playerIndividualScore;
//    private JLabel playerScoreLabel;
    private JLabel playerPointer;
    private int playerIndexNumber;
    private int playerScoreValue = 0;
    private JLabel playerScorePreview;

    PlayerStatusPanel() {
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

        playerPointer = new JLabel();
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
            playerPointer.setVisible(playerIndexNumber == 0);
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
            Image playerNameGraphic = new ImageIcon("src\\main\\resources\\infoPanel\\player" + playerIndexNumber + ".png")
                    .getImage().getScaledInstance(
                            (playerStatusPanelBounds[2] - (playerStatusPanelBounds[2] >> 2)),
                            pointerBounds[3],
                            Image.SCALE_SMOOTH
                    );
            playerName.setIcon(new ImageIcon(playerNameGraphic));
        }
        add(playerName);

//        *     SCORES

        playerScorePreview = new JLabel();
        {
            playerScorePreview.setBounds(
                    playerStatusPanelBounds[2] >> 2,
                    (playerStatusPanelBounds[3] / numberOfPlayers) >> 1,
                    playerStatusPanelBounds[2] >> 1,
                    ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers
            );
            Image playerScoreIcon = new ImageIcon("src\\main\\resources\\infoPanel\\" + playerScoreValue + ".png")
                    .getImage().getScaledInstance(
                            ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers,
                            ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers,
                            Image.SCALE_SMOOTH);
            playerScorePreview.setIcon(new ImageIcon(playerScoreIcon));
        }
        add(playerScorePreview);
    }

    /*public*/ static void setNextPlayer() {
        currentPlayerIndex = (++currentPlayerIndex) % MainFrame.numberOfPlayers;

//        return currentPlayerIndex;
    }

    /*public*/ static void refreshPointers() {
        for (PlayerStatusPanel pointer : playerRegistry) {
            pointer.playerPointer.setVisible(pointer.playerIndexNumber == currentPlayerIndex);
        }
    }

    /*public*/ static void updateScoreBoard() {
        int cache = ++(playerRegistry.get(currentPlayerIndex).playerScoreValue);

        Image playerScoreIcon = new ImageIcon("src\\main\\resources\\infoPanel\\" + cache + ".png")
                .getImage().getScaledInstance(
                        ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers,
                        ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers,
                        Image.SCALE_SMOOTH);
        playerRegistry.get(currentPlayerIndex).playerScorePreview.setIcon(new ImageIcon(playerScoreIcon))

        ;
    }

    /*public int getPlayerIndexNumber() {
        return playerIndexNumber;
    }*/

    /*public int getPlayerScoreValue() {
        return playerScoreValue;
    }*/

    /*public void setPlayerScoreValue(int playerScoreValue) {
        this.playerScoreValue = playerScoreValue;
    }*/

    /*public int incrementPlayerScoreValue() {
        return ++playerScoreValue;
    }*/

/*    public String getScoreValueGraphicUrl() {
        return scoreValueGraphicUrl;
    }

    public void setScoreValueGraphicUrl() {
        this.scoreValueGraphicUrl = "src\\main\\resources\\infoPanel\\" + playerScoreValue + ".png";
    }*/
}
