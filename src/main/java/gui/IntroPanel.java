package gui;

import javax.swing.*;
import java.awt.*;

import static gui.MainFrame.tile_x;
import static gui.MainFrame.tile_y;
import static mechanics.type.Music.playMusicBackground;
import static mechanics.type.Music.playMusicInro;

public class IntroPanel extends JPanel {

    Image introImage;
    String introImageUrl = "src\\main\\resources\\intro\\intro.gif";

    public IntroPanel() {
        setVisible(true);
        setLayout(null);
        setBounds(0, 0, tile_x, tile_y);
        introImage = Toolkit.getDefaultToolkit().createImage(introImageUrl);
        playMusicInro("src\\main\\resources\\SFX\\introMusic.wav");
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        setVisible(false);
                        playMusicBackground("src\\main\\resources\\SFX\\backgroundMusicLoops1.wav");
                    }
                },
                5080
        );

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (introImage != null)
            g.drawImage(introImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
