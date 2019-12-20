package gra.memory;

import gra.memory.gui.MainFrame;

import java.awt.*;

public class Main {

    private static MainFrame mainFrame;

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            mainFrame = new MainFrame(true);
            GraphicsEnvironment.
                    getLocalGraphicsEnvironment().
                    getDefaultScreenDevice().
                    setFullScreenWindow(mainFrame);
            /*            GraphicsEnvironment graphics =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice device = graphics.getDefaultScreenDevice();
            device.setFullScreenWindow(mainFrame);*/
        });
    }
}
