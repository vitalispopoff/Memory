package gui;

import gui.infoPanel.*;
import mechanics.type.Music;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	BackgroundPanel
		backgroundPanel = new BackgroundPanel();

	GameHeadline
		gameHeadline = new GameHeadline();

	MenuPanel
		menuPanel/* = new MenuPanel()*/;

	CardPaneling
		cardPanel = new CardPanel();

	PlayerStatusPanel
		playerStatusPanel0 = new PlayerStatusPanel(),
		playerStatusPanel1 = new PlayerStatusPanel();


	public MainFrame(boolean intro) {

		super();

		menuPanel = new MenuPanel();

		setLayout(null);
		setUndecorated(true);
		setVisible(true);

        if (intro) {
            add(new IntroPanel());
        }

        else {
            Music.playMusicBackground();
        }

		setIconImage(new ImageIcon("src\\main\\resources\\gameIcon.png").getImage());

		add(gameHeadline);

/*        InfoPaneling infoPanel = new InfoPanel();
        add((Component) infoPanel);
*/   //  ? disposable ?

		add(menuPanel);
		add((Component) cardPanel);
		add(playerStatusPanel0);
		add(playerStatusPanel1);
		add(backgroundPanel);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}