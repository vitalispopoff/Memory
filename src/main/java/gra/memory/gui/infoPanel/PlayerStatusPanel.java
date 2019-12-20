package gra.memory.gui.infoPanel;

import gra.memory.gui.TemporalParent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerStatusPanel extends TemporalParent {

    private static ArrayList<PlayerStatusPanel> playerRegistry = new ArrayList<>();
    private static int playerNumberCounter = 0;
    private static int currentPlayerIndex = 0;

    private JLabel playerPointer;
    private int playerIndexNumber;
    private int playerScoreValue = 0;
    private JLabel playerScorePreview;

    public PlayerStatusPanel() {
        super();
        this.playerIndexNumber = playerNumberCounter++;
        playerRegistry.add(playerIndexNumber, this);

//        *     LOCAL DIMENSION VALUES
        int locationVerticalComponent = playerStatusPanelBounds[1] +
                (playerIndexNumber * playerStatusPanelBounds[3] / numberOfPlayers);
        int[] pointerBounds = {
                0,
                0,
                playerStatusPanelBounds[2] >> 2,
                (playerStatusPanelBounds[3] / numberOfPlayers) >> 1
        };

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
            Font pointerFont = Saloon_Girl.deriveFont(64.F);
            playerPointer.setBackground(new Color(255, 255, 0, 96));
            playerPointer.setFont(pointerFont);
            playerPointer.setHorizontalTextPosition(SwingConstants.CENTER);
            playerPointer.setText("»");
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
            Font writingFont = Jandysdua.deriveFont(48.f);
            playerName.setBackground(new Color(255, 255, 0, 96));
            playerName.setFont(writingFont);
            playerName.setText("Player " + (playerIndexNumber + 1));
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
            Font writingFont = Jandysdua.deriveFont(48.f);
            playerScorePreview.setBackground(new Color(255, 255, 0, 96));
            playerScorePreview.setFont(writingFont);
            playerScorePreview.setText(playerScoreValue+(playerScoreValue == 1 ? " point" : " points"));
        }
        add(playerScorePreview);
    }

    public static void setNextPlayer() {
        currentPlayerIndex = (++currentPlayerIndex) % numberOfPlayers;
    }

    public static void refreshPointers() {
        for (PlayerStatusPanel pointer : playerRegistry) {
            pointer.playerPointer.setVisible(pointer.playerIndexNumber == currentPlayerIndex);
        }
    }

    public static void updateScoreBoard() {
        int cache = ++(playerRegistry.get(currentPlayerIndex).playerScoreValue);
        playerRegistry.get(currentPlayerIndex).playerScorePreview.setText(cache+(cache == 1 ? " point" : " points"));
    }
}