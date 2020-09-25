package gui;

import mechanics.type.Music;

import javax.swing.*;
import java.awt.*;

import static mechanics.type.Music.playMusicBackground;
import static mechanics.type.Music.playMusicIntro;

public class IntroPanel extends JPanel {

    private static final String
        catalog = "src\\main\\resources\\intro\\";

    private final Image
        introImage;

    IntroPanel() {

        setVisible(true);
        setLayout(null);

        setBounds(0, 0, TemporalParent.tile_x, TemporalParent.tile_y);

        introImage = Toolkit.getDefaultToolkit().createImage(catalog + "intro.gif");

/*
        Music.playMusicIntro(catalog + "introMusic.wav");
*/  // ! playMusicIntro : temporarily disabled

        new java.util.Timer().schedule(
                new java.util.TimerTask() {

                    @Override
                    public void run() {

                        setVisible(false);

/*
                        Music.playMusicBackground();
*/  // ! playMusicBackgroud : temporarily disabled

                    }
                },
                5080
        );
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (introImage != null) g.drawImage(introImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}