package gui;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;

import static gui.MainFrame.*;


public class LeftPanel extends JPanel{


    public LeftPanel() {
        setLeftPanel(this);

    }

    public static void setLeftPanel(LeftPanel leftPanel) {
        leftPanel.setBounds(
                tile >> 5,
                tile >> 5,
                tile_x - (tile_x >> 2) - (tile >> 3),
                tile_y - (tile >> 3) + (tile >> 5));
        leftPanel.setBackground(new Color(64, 192, 255));
        MigLayout Layout = new MigLayout();
        leftPanel.setLayout(Layout);
    }

    void populatePanel(){}
}
