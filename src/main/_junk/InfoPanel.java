package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static gui.BackgroundPanel.tile_x;
import static gui.BackgroundPanel.tile_y;

class InfoPanel extends TemporalParent implements InfoPaneling {

/*    private static int[] infoPanelBounds = {
            (tile_x >> 1) + (tile_x >> 2) - (tile_x >> 5),
            tile_y >> 3,
            (tile_x >> 2) + (tile_x >> 6),
            tile_y - (tile_y >> 2) + (tile_y >> 5)
    };*/    // TODO disposable

//    * PLAYERS

    static boolean isPlayer_2Move = true;
    private static int player_1Score = 0;
    private static int player_2Score = 0;
    static int[] playerPoints = {player_1Score, player_2Score};
    private static JLabel player_1ScoreLabel = new JLabel();
    private static JLabel player_2ScoreLabel = new JLabel();
    private static JLabel player_1Pointer;
    private static JLabel player_2Pointer;

    static void refreshPointers() {
        player_1Pointer.setVisible(!isPlayer_2Move);
        player_2Pointer.setVisible(isPlayer_2Move);
    }

    static void updateScoreBoard() {
        int cache = InfoPanel.isPlayer_2Move ? 1 : 0;

        Image ScoreIcon = new ImageIcon("src\\main\\resources\\infoPanel\\" + playerPoints[cache] + ".png")
                .getImage().getScaledInstance(
                        ((infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 3)) >> 1,
                        ((infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 3)) >> 1,
                        Image.SCALE_SMOOTH);
        switch (cache) {
            case 0:
                player_1ScoreLabel.setIcon(new ImageIcon(ScoreIcon));
                player_1ScoreLabel.revalidate();
                break;
            case 1:
                player_2ScoreLabel.setIcon(new ImageIcon(ScoreIcon));
                player_2ScoreLabel.revalidate();
                break;
        }
    }

    InfoPanel() {
        super();

//        *     INFO PANEL properties

        {
            setLayout(null);
            setBounds(
                    infoPanelBounds[0],
                    infoPanelBounds[1],
                    infoPanelBounds[2],
                    infoPanelBounds[3]
            );
            setOpaque(true);
            setBackground(new Color(0, 255, 0, 128));
        }

        //       *      QUIT BUTTON

/*        JLabel rageQuit = new JLabel();
        {
            rageQuit.setBounds(
                    (infoPanelBounds[3] >> 3) + (infoPanelBounds[3] >> 5),
                    (infoPanelBounds[3]) - (infoPanelBounds[3] >> 4) - (infoPanelBounds[3] >> 5),
                    (infoPanelBounds[3] >> 2) - (infoPanelBounds[3] >> 5),
                    (infoPanelBounds[3] >> 3) - (infoPanelBounds[3] >> 5)
            );
            rageQuit.setOpaque(true);
            rageQuit.setBackground(new Color(255,255,0,128));   // TODO $%^
            rageQuit.setVisible(true);
            Image quitUrl = new ImageIcon("src\\main\\resources\\infoPanel\\quit.png")
                    .getImage().getScaledInstance(
                            (infoPanelBounds[3] >> 2) - (infoPanelBounds[3] >> 5),
                            (infoPanelBounds[3] >> 3) - (infoPanelBounds[3] >> 5),
                            Image.SCALE_SMOOTH);*/
//            rageQuit.setIcon(new ImageIcon(quitUrl));

/*            rageQuit.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
            });
        }
        add(rageQuit);*/

//        JLabel panelHeadline = new JLabel();
/*        {
            panelHeadline.setBounds(
                    0,
                    0,
                    infoPanelBounds[2],
                    (infoPanelBounds[2] * 226 / 910)
            );
            panelHeadline.setOpaque(true);
            panelHeadline.setVisible(true);
            Image panelHeadlineUrl = new ImageIcon("src\\main\\resources\\infoPanel\\memory.png")
                    .getImage().getScaledInstance(
                            infoPanelBounds[2],
                            (infoPanelBounds[2] * 226 / 910),
                            Image.SCALE_SMOOTH);
//            panelHeadline.setIcon(new ImageIcon(panelHeadlineUrl));
            panelHeadline.setBackground(new Color(255,255,0,128));   // TODO $%^

        }*/
//        add(panelHeadline);


//        *     SCOREBOARD

/*        player_1ScoreLabel.setBounds(
                (infoPanelBounds[2] >> 1),
                (infoPanelBounds[3] >> 2) + (infoPanelBounds[3] >> 3) + (infoPanelBounds[3] >> 5),
                ((infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 3)) >> 1,
                ((infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 3)) >> 1
        );*/
/*        Image player_1ScoreIcon = new ImageIcon("src\\main\\resources\\infoPanel\\0.png")
                .getImage().getScaledInstance(
                        ((infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 3)) >> 1,
                        ((infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 3)) >> 1,
                        Image.SCALE_SMOOTH);
//        player_1ScoreLabel.setIcon(new ImageIcon(player_1ScoreIcon));
        player_1ScoreLabel.setBackground(new Color(255, 0,0,128)); // TODO $%^
        player_1ScoreLabel.setOpaque(true);
        add(player_1ScoreLabel);*/

/*        player_2ScoreLabel.setBounds(
                (infoPanelBounds[2] >> 1),
                (infoPanelBounds[3] >> 1) + (infoPanelBounds[3] >> 2),
                ((infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 3)) >> 1,
                ((infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 3)) >> 1
        );
        Image player_2ScoreIcon = new ImageIcon("src\\main\\resources\\infoPanel\\0.png")
                .getImage().getScaledInstance(
                        ((infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 3)) >> 1,
                        ((infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 3)) >> 1,
                        Image.SCALE_SMOOTH);
//        player_2ScoreLabel.setIcon(new ImageIcon(player_2ScoreIcon));
        player_2ScoreLabel.setBackground(new Color(255, 0,0,128)); // TODO $%^
        player_2ScoreLabel.setOpaque(true);
        add(player_2ScoreLabel);*/

//        *     POINTERS

/*        {
            Image PointerIcon = new ImageIcon("src\\main\\resources\\infoPanel\\pointer.png")
                    .getImage().getScaledInstance(
                            ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2)) / 3,
                            ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2)) / 3,
                            Image.SCALE_SMOOTH);

            player_1Pointer = new JLabel();
            player_1Pointer.setBounds(
                    0,
                    (infoPanelBounds[3] >> 2),
                    ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2)) / 3,
                    ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2)) / 3
            );

            player_1Pointer.setBackground(new Color(255, 255,255,128)); // TODO $%^

            player_2Pointer = new JLabel();
            player_2Pointer.setBounds(
                    0,
                    (infoPanelBounds[3] >> 1) + (infoPanelBounds[3] >> 4) + (infoPanelBounds[3] >> 5),
                    ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2)) / 3,
                    ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2)) / 3
            );
//            player_2Pointer.setIcon(new ImageIcon(PointerIcon));
            player_2Pointer.setOpaque(true);
            player_2Pointer.setBackground(new Color(255, 255,255,128)); // TODO $%^

        }
        refreshPointers();
        add(player_1Pointer);
        add(player_2Pointer);*/

//        *     PLAYER HEADLINES

        /*JLabel player_1Headline = new JLabel();
        {
            player_1Headline.setBounds(
                    (infoPanelBounds[2] >> 2),
                    (infoPanelBounds[3] >> 2),
                    (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2),
                    ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2)) / 3
            );
            player_1Headline.setOpaque(true);
            player_1Headline.setBackground(new Color(0, 255,255,128)); // TODO $%^
            player_1Headline.setVisible(true);
            Image player_1HeadlineUrl = new ImageIcon("src\\main\\resources\\infoPanel\\player1.png")
                    .getImage().getScaledInstance(
                            (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2),
                            ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2)) / 3,
                            Image.SCALE_SMOOTH
                    );*/
//            player_1Headline.setIcon(new ImageIcon(player_1HeadlineUrl));
//    }

/*        JLabel player_2Headline = new JLabel();
        {
            player_2Headline.setBounds(
                    (infoPanelBounds[2] >> 2),
                    (infoPanelBounds[3] >> 1) + (infoPanelBounds[3] >> 4) + (infoPanelBounds[3] >> 5),
                    (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2),
                    ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2)) / 3
            );
            player_2Headline.setOpaque(true);
            player_2Headline.setBackground(new Color(255,0,255,128)); // TODO $%^
            player_2Headline.setVisible(true);
            Image player_2HeadlineUrl = new ImageIcon("src\\main\\resources\\infoPanel\\player2.png")
                    .getImage().getScaledInstance(
                            (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2),
                            ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 2)) / 3,
                            Image.SCALE_SMOOTH
                    );*/
//            player_2Headline.setIcon(new ImageIcon(player_2HeadlineUrl));
//}

/*        add(player_1Headline);
        add(player_2Headline);*/


    }
}
