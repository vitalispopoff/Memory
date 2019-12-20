package gra.memory.gui;

import gra.memory.gui.infoPanel.GameHeadline;
import gra.memory.gui.infoPanel.MenuPanel;
import gra.memory.gui.infoPanel.PlayerStatusPanel;
import gra.memory.mechanics.type.Music;

import javax.swing.*;

import java.awt.*;

import static gra.memory.mechanics.type.Music.playMusicBackground;

public class MainFrame extends JFrame {

//    public static int numberOfPlayers = 4;

    public MainFrame(boolean intro) {
        super();
        setLayout(null);
        setUndecorated(true);
        setVisible(true);

        if (intro) add(new IntroPanel());
        else Music.playMusicBackground();

        setIconImage(new ImageIcon("src\\main\\resources\\gameIcon.png").getImage());
        BackgroundPanel backgroundPanel = new BackgroundPanel();

        GameHeadline gameHeadline = new GameHeadline();
        add(gameHeadline);

/*        InfoPaneling infoPanel = new InfoPanel();
        add((Component) infoPanel);*/   //  TODO    disposable ?

        MenuPanel menuPanel = new MenuPanel();
        add(menuPanel);

        CardPaneling cardPanel = new CardPanel();
        add((Component) cardPanel);

        PlayerStatusPanel playerStatusPanel0 = new PlayerStatusPanel();
        PlayerStatusPanel playerStatusPanel1 = new PlayerStatusPanel();
//        PlayerStatusPanel playerStatusPanel2 = new PlayerStatusPanel();
//        PlayerStatusPanel playerStatusPanel3 = new PlayerStatusPanel();
        add(playerStatusPanel0);
        add(playerStatusPanel1);
//        add(playerStatusPanel2);
//        add(playerStatusPanel3);





        add(backgroundPanel);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
