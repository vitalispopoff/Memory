package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class PlayerStatusPanel extends TemporalParent {

    private static ArrayList<PlayerStatusPanel> playerRegistry = new ArrayList<>();
    private static int playerNumberCounter = 0;
    private static int currentPlayerIndex = 0;

    private JLabel playerPointer;
    private int playerIndexNumber;
    private int playerScoreValue = 0;
    private JLabel playerScorePreview;

    PlayerStatusPanel() {
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
/*            Image PointerIcon = new ImageIcon("src\\main\\resources\\infoPanel\\pointer.png")
                    .getImage().getScaledInstance(
                            pointerGraphicSize,
                            pointerGraphicSize,
                            Image.SCALE_SMOOTH);
            playerPointer.setIcon(new ImageIcon(PointerIcon));*/
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
/*            try {
                Image playerNameGraphic = new ImageIcon("src\\main\\resources\\infoPanel\\player" + playerIndexNumber + ".png")
                        .getImage().getScaledInstance(
                                (playerStatusPanelBounds[2] - (playerStatusPanelBounds[2] >> 2)),
                                pointerBounds[3],
                                Image.SCALE_SMOOTH
                        );

//                playerName.setIcon(new ImageIcon(playerNameGraphic));
            } catch (Exception e) {
                System.out.println("No such file, sorry.");
            }*/     // (TODO) disposable (graphic representation)

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
/*                Image playerScoreIcon = new ImageIcon("src\\main\\resources\\infoPanel\\" + playerScoreValue + ".png")
                        .getImage().getScaledInstance(
                                ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers,
                                ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers,
                                Image.SCALE_SMOOTH);
                playerScorePreview.setIcon(new ImageIcon(playerScoreIcon));*/   //  (TODO)  disposable?
            Font writingFont = Jandysdua.deriveFont(48.f);
            playerScorePreview.setBackground(new Color(255, 255, 0, 96));
            playerScorePreview.setFont(writingFont);
            playerScorePreview.setText(playerScoreValue+(playerScoreValue == 1 ? " point" : " points"));
        }
        add(playerScorePreview);
    }

    static void setNextPlayer() {
        currentPlayerIndex = (++currentPlayerIndex) % numberOfPlayers;
    }

    static void refreshPointers() {
        for (PlayerStatusPanel pointer : playerRegistry) {
            pointer.playerPointer.setVisible(pointer.playerIndexNumber == currentPlayerIndex);
        }
    }

    static void updateScoreBoard() {
        int cache = ++(playerRegistry.get(currentPlayerIndex).playerScoreValue);
/*        Image playerScoreIcon = new ImageIcon("src\\main\\resources\\infoPanel\\" + cache + ".png")
                .getImage().getScaledInstance(
                        ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers,
                        ((playerStatusPanelBounds[3] >> 1) - (playerStatusPanelBounds[3] >> 5)) / numberOfPlayers,
                        Image.SCALE_SMOOTH);
        playerRegistry.get(currentPlayerIndex).playerScorePreview.setIcon(new ImageIcon(playerScoreIcon));*/    //  (TODO) disposable?
        playerRegistry.get(currentPlayerIndex).playerScorePreview.setText(cache+(cache == 1 ? " point" : " points"));
    }
}