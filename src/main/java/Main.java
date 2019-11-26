import gui.MainFrame;
import gui.intro.MyJFrame;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

       /* EventQueue.invokeLater(() -> {
            MainFrame.createAndShowGUI();

        });*/

        EventQueue.invokeLater(() -> {
            MyJFrame window = new MyJFrame();
            GraphicsEnvironment graphics =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice device = graphics.getDefaultScreenDevice();
            device.setFullScreenWindow(window);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            window.setVisible(false);
                            MainFrame.createAndShowGUI();

                        }
                    },
                    4300
            );

        });
    }
}

/**
 * Icon by Linector: https://www.flaticon.com/authors/linector
 * Vectors on card fronts by rawpixel.com - www.freepik.com:
 * https://www.freepik.com/free-photos-vectors/vintage,
 * https://www.freepik.com/free-photos-vectors/vintage,
 * https://www.freepik.com/free-photos-vectors/vintage,
 * https://www.freepik.com/free-photos-vectors/background
 *
 * Sounds effects from Freesound.org community:
 * 434472__dersuperanton__taking-card
 * 240777__f4ngy__dealing-card
 * 240776__f4ngy__card-flip
 * 485010__g-e-n-e__card-shuffle
 *
 * Sound loops used under the public domain (1) and fair use policy (2, 3, 4) respectively.
 *
 * 1. Scott Joplin - The Entertainer
 * 2. Duke Ellington - You Gave Me The Gate
 * 3. Beastie Boys - The Sound Of The Neckbone
 * 4. Beastie Boys - Groove Holmes
 */
