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
        int numberOfPlayers=2;
        PlayerStatusPanel playerStatusPanel0 = new PlayerStatusPanel(numberOfPlayers);
        PlayerStatusPanel playerStatusPanel1 = new PlayerStatusPanel(numberOfPlayers);

        add(menuPanel);
        add(gameHeadline);
        add(playerStatusPanel0);
        add(playerStatusPanel1);


//        if (intro) add(new IntroPanel());
//        else playMusicBackground();
//        add((Component) infoPanel);
        add((Component) cardPanel);
        add(backgroundPanel);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
