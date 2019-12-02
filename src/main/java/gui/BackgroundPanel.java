package gui;

import javax.swing.*;
import java.awt.*;



public class BackgroundPanel extends JPanel {

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int tile_x = screenSize.width;
    public static int tile_y = screenSize.height+5;
    public static int tile = Integer.min(tile_x, tile_y);


    public BackgroundPanel() {
        super();

        setOpaque(false);
        setBounds(0, 0 - 5, tile_x,tile_y);
        String fileAddress = "src\\main\\resources\\bcg.jpg";
        Image sheet = new ImageIcon(fileAddress).getImage().getScaledInstance(
                tile_x,
                tile_y,
                Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(sheet));
        add(label);
    }
}
