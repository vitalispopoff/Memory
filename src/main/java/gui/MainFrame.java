package gui;

import javax.swing.*;

import static mechanics.type.Music.playMusicBackground;

public class MainFrame extends JFrame {

    public MainFrame(boolean intro) {
        super();
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setIconImage(new ImageIcon("src\\main\\resources\\gameIcon.png").getImage());

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        CardPanel cardPanel = new CardPanel();
        InfoPanel infoPanel = new InfoPanel();

        if (intro) add(new IntroPanel());
        else playMusicBackground();
        add(infoPanel);
        add(cardPanel);
        add(backgroundPanel);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
