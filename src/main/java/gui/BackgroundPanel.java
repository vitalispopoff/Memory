package gui;

import javax.swing.*;
import java.awt.*;

import static mechanics.type.Music.playMusicBackground;


public class BackgroundPanel extends JPanel {

    public BackgroundPanel() {
        super();

        setOpaque(false);
        setBounds(0, 0 - 5, MainFrame.tile_x, MainFrame.tile_y);
        String fileAddress = "src\\main\\resources\\bcg.jpg";
        Image sheet = new ImageIcon(fileAddress).getImage().getScaledInstance(
                MainFrame.tile_x,
                MainFrame.tile_y,
                Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(sheet));
        add(label);
    }
}
