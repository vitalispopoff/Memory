package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static gui.MainFrame.tile_x;
import static gui.MainFrame.tile_y;

public class InfoPanel extends JPanel {
    int[] infoPanelBounds = {
            (tile_x >> 1) + (tile_x >> 2) - (tile_x >> 5),
            tile_y >> 3,
            (tile_x >> 2) + (tile_x >> 6),
            tile_y - (tile_y >> 2) + (tile_y >> 5)
    };

    public int roundNumber = 0;
    String player_1Name = "Gracz I ";
    String player_2Name = "Gracz II ";
    public String playerName = "zbyszek";   // name of a player currently at the table

    static boolean player_2Move;
    static {player_2Move =false;}
    String[] fontColors = {" #aa3300", "#000000"};
    String player_1FontColor = player_2Move ? fontColors[1] : fontColors[0];
    String player_2FontColor = player_2Move ? fontColors[0] : fontColors[1];


    int player_1PointNumber = 0;
    int player_2PointNumber = 0;


    public InfoPanel() {
        super();
        setLayout(null);
        setBounds(
                infoPanelBounds[0],
                infoPanelBounds[1],
                infoPanelBounds[2],
                infoPanelBounds[3]
        );
        setBackground(new Color(255, 255, 255, 00));


        JLabel roundTitleLabel = new JLabel();
        roundTitleLabel.setHorizontalAlignment(0);
        roundTitleLabel.setVerticalAlignment(0);
        String roundTitleLabelText = "<html><p style=\" font-weight: bold; font-style: italic; font-size: 32px;font-family: Helvetica, Arial, Sans-Serif;\"><u>KOLEJKA</u></p></html>";
        roundTitleLabel.setText(roundTitleLabelText);
        roundTitleLabel.setBounds(
                0,
                0,
                (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 4),
                infoPanelBounds[3] >> 3
        );
        roundTitleLabel.setVisible(true);
//        roundTitleLabel.setBackground(new Color(255, 255, 0, 128));
//        roundTitleLabel.setBorder(new LineBorder(new Color(0, 0, 0, 128), 1, true));
        add(roundTitleLabel);


        JLabel roundNumberLabel = new JLabel();
        roundNumberLabel.setHorizontalAlignment(0);
        roundNumberLabel.setVerticalAlignment(0);
        String roundNumberLabelText = "<html><p style=\" font-weight: bold; font-style: italic; font-size: 32px;font-family: Helvetica, Arial, Sans-Serif;\">" + roundNumber + "</p></html>";
        roundNumberLabel.setText(roundNumberLabelText);
        roundNumberLabel.setBounds(
                (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3),
                0,
                infoPanelBounds[2] >> 2,
                infoPanelBounds[3] >> 3
        );
//        roundNumberLabel.setBorder(new LineBorder(new Color(0, 0, 0, 128), 1, true));
        add(roundNumberLabel);


        JLabel player_1Label = new JLabel();
        player_1Label.setHorizontalAlignment(0);
        player_1Label.setVerticalAlignment(0);
        String player_1NameText = "<html><p style=\" color:" + player_1FontColor + "; font-size:20px; font-family: Helvetica, Arial, Sans-Serif;\">" + player_1Name + "</p></html>";
        player_1Label.setText(player_1NameText);
        player_1Label.setBounds(
                0,
                (infoPanelBounds[3] >> 2) - (infoPanelBounds[3] >> 4),
                infoPanelBounds[2] - (infoPanelBounds[2] >> 3),
                infoPanelBounds[3] >> 3
        );
//        player_1Label.setBorder(new LineBorder(new Color(0, 0, 0, 128), 1, true));
        add(player_1Label);


        JLabel player_1PointTitleLabel = new JLabel();
        player_1PointTitleLabel.setHorizontalAlignment(0);
        player_1PointTitleLabel.setVerticalAlignment(0);
        String player_1PointTitleText = "<html><p style=\" color:" + player_1FontColor + "; font-size: 18px; font-family: Helvetica, Arial, Sans-Serif;\">punkty</p></html>";
        player_1PointTitleLabel.setText(player_1PointTitleText);
        player_1PointTitleLabel.setBounds(
                0,
                (infoPanelBounds[3] >> 2) + (infoPanelBounds[3] >> 4),
                (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 4),
                infoPanelBounds[3] >> 3
        );
//        player_1PointTitleLabel.setBorder(new LineBorder(new Color(0, 0, 0, 128), 1, true));
        add(player_1PointTitleLabel);


        JLabel player_1PointNumberLabel = new JLabel();
        player_1PointNumberLabel.setHorizontalAlignment(0);
        player_1PointNumberLabel.setVerticalAlignment(0);
        String player_1PointNumberText = "<html><p style=\" color:" + player_1FontColor + "; font-size: 18px;font-family: Helvetica, Arial, Sans-Serif;\">" + player_1PointNumber + "</p></html>";
        player_1PointNumberLabel.setText(player_1PointNumberText);
        player_1PointNumberLabel.setBounds(
                (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3),
                (infoPanelBounds[3] >> 2) + (infoPanelBounds[3] >> 4),
                infoPanelBounds[2] >> 2,
                infoPanelBounds[3] >> 3
        );
//        player_1PointNumberLabel.setBorder(new LineBorder(new Color(0, 0, 0, 128), 1, true));
        add(player_1PointNumberLabel);


        JLabel player_2Label = new JLabel();
        player_2Label.setHorizontalAlignment(0);
        player_2Label.setVerticalAlignment(0);
        String player_2NameText = "<html><p style=\" color:" + player_2FontColor + "; font-size:20px; font-family: Helvetica, Arial, Sans-Serif;\">" + player_2Name + "</p></html>";
        player_2Label.setText(player_2NameText);
        player_2Label.setBounds(
                0,
                infoPanelBounds[3] >> 1,
                infoPanelBounds[2] - (infoPanelBounds[2] >> 3),
                infoPanelBounds[3] >> 3
        );
//        player_2Label.setBorder(new LineBorder(new Color(0, 0, 0, 128), 1, true));
        add(player_2Label);


        JLabel player_2PointTitleLabel = new JLabel();
        player_2PointTitleLabel.setHorizontalAlignment(0);
        player_2PointTitleLabel.setVerticalAlignment(0);
        String player_2PointTitleText = "<html><p style=\" color:" + player_2FontColor + "; font-size: 18px; font-family: Helvetica, Arial, Sans-Serif;\">punkty</p></html>";
        player_2PointTitleLabel.setText(player_2PointTitleText);
        player_2PointTitleLabel.setBounds(
                0,
                (infoPanelBounds[3] >> 1) + (infoPanelBounds[3] >> 3),
                (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 4),
                infoPanelBounds[3] >> 3
        );
//        player_2PointTitleLabel.setBorder(new LineBorder(new Color(0, 0, 0, 128), 1, true));
        add(player_2PointTitleLabel);


        JLabel player_2PointNumberLabel = new JLabel();
        player_2PointNumberLabel.setHorizontalAlignment(0);
        player_2PointNumberLabel.setVerticalAlignment(0);
        String player_2PointNumberText = "<html><p style=\" color:" + player_2FontColor + "; font-size: 18px;font-family: Helvetica, Arial, Sans-Serif;\">" + player_2PointNumber + "</p></html>";
        player_2PointNumberLabel.setText(player_2PointNumberText);
        player_2PointNumberLabel.setBounds(
                (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3),
                (infoPanelBounds[3] >> 1) + (infoPanelBounds[3] >> 3),
                infoPanelBounds[2] >> 2,
                infoPanelBounds[3] >> 3
        );
//        player_2PointNumberLabel.setBorder(new LineBorder(new Color(0, 0, 0, 128), 1, true));
        add(player_2PointNumberLabel);


    }


}
