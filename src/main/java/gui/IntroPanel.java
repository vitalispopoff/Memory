package gui;

import javax.swing.*;
import java.awt.*;

import static gui.MainFrame.tile_x;
import static gui.MainFrame.tile_y;

public class IntroPanel extends JPanel {

    Image introImage;
    String introImageUrl = "src\\main\\resources\\intro\\intro.gif";

    public IntroPanel() {
        setVisible(true);
        setLayout(null);
        setBounds(0, 0, tile_x, tile_y);
        introImage = Toolkit.getDefaultToolkit().createImage(introImageUrl);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        setVisible(false);
                    }
                },
                4600
        );

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (introImage != null)
            g.drawImage(introImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
