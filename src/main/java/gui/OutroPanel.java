package gui;

import javax.swing.*;
import java.awt.*;

import static gui.BackgroundPanel.tile_x;
import static gui.BackgroundPanel.tile_y;
import static mechanics.type.Music.playMusicIntro;

public class OutroPanel extends JPanel {

    Image outroImage;
    String outroImageUrl = "src\\main\\resources\\outro\\outro.gif";

    public OutroPanel() {
        setVisible(true);
        setLayout(null);
        setBounds(0, 0, tile_x, tile_y);
        outroImage = Toolkit.getDefaultToolkit().createImage(outroImageUrl);
        playMusicIntro("src\\main\\resources\\outro\\outroMusic.wav");
        /*new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        setVisible(false);
//                        playMusicBackground("src\\main\\resources\\SFX\\backgroundMusicLoops1.wav");
                    }
                },
                5080
        );*/

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (outroImage != null)
            g.drawImage(outroImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
