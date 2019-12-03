package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static gui.BackgroundPanel.tile_x;
import static gui.BackgroundPanel.tile_y;

public class InfoPanel extends JPanel {
    int[] infoPanelBounds = {
            (tile_x >> 1) + (tile_x >> 2) - (tile_x >> 5),
            tile_y >> 3,
            (tile_x >> 2) + (tile_x >> 6),
            tile_y - (tile_y >> 2) + (tile_y >> 5)
    };

    public int roundNumber = 0;

//    * PLAYERS

    String player_1Name = "Gracz I ";
    String player_2Name = "Gracz II ";

//    public String playerName = "zbyszek";   // name of a player currently at the table

    public static boolean isPlayer_2Move = false;

/*    static String[] fontColors = {" #aa3300", "#000000"};
    static String player_1FontColor = isPlayer_2Move ? fontColors[1] : fontColors[0];
    static String player_2FontColor = isPlayer_2Move ? fontColors[0] : fontColors[1];
    static String[]playerColors={player_1FontColor, player_2FontColor};*/


    static int player_1PointNumber = 0;
    static int player_2PointNumber = 0;
    public static int[] playerPoints = {player_1PointNumber, player_2PointNumber};


    static JLabel player_1PointNumberLabel = new JLabel();
    static JLabel player_2PointNumberLabel = new JLabel();
    static JLabel[] scoreboard = {player_1PointNumberLabel, player_1PointNumberLabel};


/*    public static  void updateScoreBoard(){
        int cache = InfoPanel.isPlayer_2Move?0:1;
        scoreboard[cache].setText(new StringBuilder()
                .append("<html><p style=\" color:")
                .append(playerColors[cache])
                .append("; font-size: 18px;font-family: Helvetica, Arial, Sans-Serif;\">")
                .append(playerPoints[InfoPanel.playerPoints[InfoPanel.isPlayer_2Move?0:1]])
                .append("</p></html>")
                .toString());*/


//        InfoPanel.playerPoints[InfoPanel.isPlayer_2Move?0:1]++;


    public InfoPanel() {
        super();
        setLayout(null);
        setBounds(
                infoPanelBounds[0],
                infoPanelBounds[1],
                infoPanelBounds[2],
                infoPanelBounds[3]
        );
        setBackground(new Color(255, 255, 255, 128));




        JButton restart = new JButton();
        restart.setBounds(
                0,
                (infoPanelBounds[3]) - (infoPanelBounds[3] >> 4) - (infoPanelBounds[3] >> 5),
                (infoPanelBounds[3] >> 2) - (infoPanelBounds[3] >> 5),
                (infoPanelBounds[3] >> 3) - (infoPanelBounds[3] >> 5)
        );
        restart.setOpaque(false);
        restart.setVisible(true);
        restart.setIcon(new ImageIcon("src\\main\\resources\\buttons\\play_again.png"));

//        player_2PointNumberLabel.setBorder(new LineBorder(new Color(0, 0, 0, 128), 1, true));
        //restartt.setText("JESZCZE RAZ");
        //restartt.setBackground(new Color(255,255,255,255));

        restart.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                //  TODO    DOPISAC AKCJE DO PRZYCISKU RESTART
            }
        });
        add(restart);

        JLabel rageQuit = new JLabel();
        rageQuit.setBounds(
                (infoPanelBounds[3] >> 2) /*+ (infoPanelBounds[3] >> 3)*/,
                (infoPanelBounds[3]) - (infoPanelBounds[3] >> 4) - (infoPanelBounds[3] >> 5),
                (infoPanelBounds[3] >> 2) - (infoPanelBounds[3] >> 5),
                (infoPanelBounds[3] >> 3) - (infoPanelBounds[3] >> 5)
        );
//        rageQuit.setOpaque(false);
//        rageQuit.setContentAreaFilled(false);
        // rageQuit.setText("(ノ°Д°）ノ︵ ┻━┻");
        rageQuit.setIcon(new ImageIcon("src\\main\\resources\\buttons\\close.png"));
        rageQuit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        rageQuit.setBackground(new Color(255, 255, 255, 255));
//        rageQuit
        add(rageQuit);

    }


}
