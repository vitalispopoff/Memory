package gui;

import gui.infoPanel.GameHeadline;
import gui.infoPanel.MenuPanel;

import javax.swing.*;

import java.awt.*;

import static mechanics.type.Music.playMusicBackground;

public class MainFrame extends JFrame {

    public MainFrame(boolean intro) {
        super();
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setIconImage(new ImageIcon("src\\main\\resources\\gameIcon.png").getImage());

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        CardPaneling cardPanel = new CardPanel();
        InfoPaneling infoPanel = new InfoPanel();
        GameHeadline gameHeadline = new GameHeadline();
        MenuPanel menuPanel = new MenuPanel();
        add(menuPanel);
        add(gameHeadline);
//        if (intro) add(new IntroPanel());
//        else playMusicBackground();
//        add((Component) infoPanel);
        add((Component) cardPanel);
        add(backgroundPanel);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
