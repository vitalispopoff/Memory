package gui;

import javax.swing.*;
import java.awt.*;

public class PlayerStatusPanel extends TemporalParent {

    private static int playerNumberCounter = 0;

//    private static int indexOfPlayerOnTheMove;
//    private static int[] playerScoreRegistry;
//    private static JLabel[] playerPointerRegistry;

    //    private int playerIndividualScore;
//    private JLabel playerScoreLabel;
//    private JLabel playerPointer;
    private int playerIndexNumber;
//    private int playerScoreValue;

    PlayerStatusPanel(int numberOfPlayers) {
        super();
        this.playerIndexNumber = playerNumberCounter++;
        setOpaque(true);
        setLayout(null);
//        setVisible(true);
        setBackground(new Color(127 * playerIndexNumber, 127 * playerIndexNumber, 127 * playerIndexNumber, 128));
        int locationVerticalComponent = playerStatusPanelBounds[1] + (playerIndexNumber * playerStatusPanelBounds[3] / numberOfPlayers);

        setBounds(
                playerStatusPanelBounds[0],
                locationVerticalComponent,
                playerStatusPanelBounds[2],
                playerStatusPanelBounds[3] / numberOfPlayers
        );

//        *     POINTER

        JLabel playerPointer = new JLabel();
        playerPointer.setBounds(
                0,
                0,
                playerStatusPanelBounds[2] >> 2,
                (playerStatusPanelBounds[3] / numberOfPlayers) >> 1
        );
        Image PointerIcon = new ImageIcon("src\\main\\resources\\infoPanel\\pointer.png")
                .getImage().getScaledInstance(
                        Math.min(playerStatusPanelBounds[2] >> 2, (playerStatusPanelBounds[3] / numberOfPlayers) >> 1),
                        Math.min(playerStatusPanelBounds[2] >> 2, (playerStatusPanelBounds[3] / numberOfPlayers) >> 1),
                        Image.SCALE_SMOOTH);
        playerPointer.setIcon(new ImageIcon(PointerIcon));
        add(playerPointer);

//        *     NAME

        JLabel playerName = new JLabel();
        playerName.setBounds(
                playerStatusPanelBounds[2] >> 2,
                0,
                (playerStatusPanelBounds[2] - (playerStatusPanelBounds[2] >> 2)),
                (playerStatusPanelBounds[3] / numberOfPlayers) >> 1
        );
        playerName.setBackground(new Color(255, 255, 0, 128));
        add(playerName);

//        *     SCORES

        JLabel playerScoreValue = new JLabel();
        playerScoreValue.setBounds(
                playerStatusPanelBounds[2] >> 2,
                (playerStatusPanelBounds[3] / numberOfPlayers) >> 1,
                playerStatusPanelBounds[2] >> 1,
                ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >>5)) / numberOfPlayers
        );
        Image playerScoreIcon = new ImageIcon("src\\main\\resources\\infoPanel\\0.png")
                .getImage().getScaledInstance(
                        ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >>5)) / numberOfPlayers,
                        ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >>5)) / numberOfPlayers,
                        Image.SCALE_SMOOTH);
                playerScoreValue.setIcon(new ImageIcon(playerScoreIcon));
        add(playerScoreValue);
    }
}
