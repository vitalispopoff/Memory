import gui.MainFrame;

import java.awt.*;


public class Main {

    public static MainFrame mainFrame;


    public static void main(String[] args) {

        EventQueue.invokeLater(()->{
            mainFrame = new MainFrame();
            GraphicsEnvironment graphics =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice device = graphics.getDefaultScreenDevice();
            device.setFullScreenWindow(mainFrame);
        });
    }
}

/**
 * Icon by Linector: https://www.flaticon.com/authors/linector
 * Vectors on card fronts by rawpixel.com - www.freepik.com:
 * https://www.freepik.com/free-photos-vectors/vintage,
 * https://www.freepik.com/free-photos-vectors/vintage,
 * https://www.freepik.com/clefree-photos-vectors/vintage,
 * https://www.freepik.com/free-photos-vectors/background
 *
 * Sounds effects from Freesound.org community:
 * 434472__dersuperanton__taking-card
 * 240777__f4ngy__dealing-card
 * 240776__f4ngy__card-flip
 * 485010__g-e-n-e__card-shuffle
 *
 * Sound loops used under the public domain (1) and fair use policy (2) respectively.
 *
 * 1. Scott Joplin - The Entertainer
 * 2. Duke Ellington - You Gave Me The Gate
 *
 * Outro scene taken from "Lo chiamavano Trinità..." under the fair use policy.
 * https://archive.org/details/theycallmetrinity1971
 *https://en.wikipedia.org/wiki/They_Call_Me_Trinity
 */
