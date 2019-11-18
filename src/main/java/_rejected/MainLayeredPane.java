package _rejected;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static _rejected.MainFrame.tile_x;
import static _rejected.MainFrame.tile_y;

public class MainLayeredPane extends JPanel {

    private static JLayeredPane layeredPane;
    private int layers = 5;
    private ArrayList<JLabel> labelList = new ArrayList<>();
//    private ArrayList<JPanel> panelList = new ArrayList<>();

    public MainLayeredPane() {
        layeredPane = new JLayeredPane();
        setLayout(null);
        setPreferredSize(new Dimension(tile_x, tile_y));

        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel());
//        mainPanel.setOpaque(true);
        mainPanel.setBounds(0, 0, tile_x, tile_y);
        mainPanel.setLayout(null);
        for (int i = 0; i < 640; i += 240) {
            for (int j = 0; j < 480; j += 240) {
                JLabel label = new JLabel(new ImageIcon(new ImageIcon("src\\main\\resources\\clothTile.png").getImage()));
                label.setBounds(i, j, 240, 240);
                mainPanel.add(label);
            }
        }


        add(layeredPane);

    }

}
