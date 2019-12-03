package gui;

import javax.swing.*;

import static mechanics.type.Music.playMusicBackground;

public class MainFrame extends JFrame {
    public static BackgroundPanel backgroundPanel;
    public static CardPanel cardPanel;
    public InfoPanel infoPanel;

    public MainFrame(boolean intro) {
        super();
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setIconImage(new ImageIcon("src\\main\\resources\\gameIcon.png").getImage());

        backgroundPanel = new BackgroundPanel();
        cardPanel = new CardPanel();
        infoPanel = new InfoPanel();

        if (intro) add(new IntroPanel());
        else playMusicBackground();
        add(infoPanel);
        add(cardPanel);
        add(backgroundPanel);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void refreshFrame() {
        /*infoPanel.*/
        revalidate();
    }


}
