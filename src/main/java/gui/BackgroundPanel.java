package gui;

import javax.swing.*;
import java.awt.*;

class BackgroundPanel extends JPanel {

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static int tile_x = screenSize.width;
    static int tile_y = screenSize.height + 5;
    static int tile = Integer.min(tile_x, tile_y);

    BackgroundPanel() {
        super();

        setOpaque(false);
        setBounds(0, 0 - 5, tile_x, tile_y);
        Image sheet = new ImageIcon("src\\main\\resources\\bcg.jpg")
                .getImage().getScaledInstance(
                        tile_x,
                        tile_y,
                        Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(sheet));
        add(label);
    }
}
