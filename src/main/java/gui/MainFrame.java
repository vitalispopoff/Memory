package gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame /*implements FrontEndable*/ {

    private static Toolkit kit = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = kit.getScreenSize();
    public static int tile_x = screenSize.width;
    public static int tile_y = screenSize.height;
    private static int tile = Integer.min(tile_x, tile_y);

    public MainFrame() throws HeadlessException {
        setResizable(false);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(255, 255, 0));
        add(mainPanel);
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(tile >> 5, tile >> 5, tile_x - (tile_x >> 2) - (tile >> 4), tile_y - (tile >> 3) + (tile >> 5));
        leftPanel.setBackground(new Color(0, 255, 255));
        mainPanel.add(leftPanel);
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(tile_x - (tile_x >> 2) - (tile >> 7), tile >> 5, (tile_x >> 2) - (tile >> 5), tile_y - (tile >> 3) + (tile >> 5));
        rightPanel.setBackground(new Color(255,0,255));
        mainPanel.add(rightPanel);

        pack();


    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(tile_x, tile_y);
    }
}