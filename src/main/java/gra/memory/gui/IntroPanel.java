package gra.memory.gui;

import gra.memory.mechanics.type.Music;

import javax.swing.*;
import java.awt.*;

import static gra.memory.mechanics.type.Music.playMusicBackground;
import static gra.memory.mechanics.type.Music.playMusicIntro;

public class IntroPanel extends JPanel {

    private Image introImage;

    IntroPanel() {
        setVisible(true);
        setLayout(null);
        setBounds(0, 0, TemporalParent.tile_x, TemporalParent.tile_y);
        String introImageUrl = "src\\main\\resources\\intro\\intro.gif";
        introImage = Toolkit.getDefaultToolkit().createImage(introImageUrl);
        Music.playMusicIntro("src\\main\\resources\\intro\\introMusic.wav");
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        setVisible(false);
                        Music.playMusicBackground();
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
