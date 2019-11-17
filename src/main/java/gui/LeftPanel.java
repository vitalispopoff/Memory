package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static gui.MainFrame.*;


public class LeftPanel extends JPanel {

    static int x = 9;
    static int y = 9;
//    static Icon cardCover = new ImageIcon("resources\\clothTile.png","piece of tablecloth");


    public LeftPanel() {
        setLeftPanel(this);

    }

    public static void setLeftPanel(LeftPanel leftPanel) {
        leftPanel.setBounds(
                tile >> 5,
                tile >> 5,
                tile_x - (tile_x >> 2) - (tile >> 3) - (tile >> 5),
                tile_y - (tile >> 3) + (tile >> 5));

//        MigLayout Layout = new MigLayout();
//        leftPanel.setLayout(Layout);
        leftPanel.setOpaque(true);      // opacity probably not needed
        leftPanel.setBackground(new Color(64, 192, 255, 0));
        leftPanel.setLayout(new GridLayout(x, y));
        populateGrid(leftPanel);
    }

    private static void populateGrid(JPanel panel/*, ActionListener*/) {

        for (int i = 0; i < x * y; i++) {
            JLabel label = new JLabel(new ImageIcon(new ImageIcon("src\\main\\resources\\clothTile.png").getImage()));
//            label.setOpaque(false);
            label.setBackground(new Color(128, 128, 128, 64));
            label.setBorder(MainFrame.blackBorder());
//            label.addActionListener(listener);
            panel.add(label);
        }

    }

    void populatePanel() {
    }
}
