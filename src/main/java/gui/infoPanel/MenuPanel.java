package gui.infoPanel;

import gui.TemporalParent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends TemporalParent {

    public static int numberOfMenuButtons=3;

    public MenuPanel() {
        setLayout(new GridLayout(1,numberOfMenuButtons));
        setOpaque(false);
        setBounds(
                menuPanelBounds[0],
                menuPanelBounds[1],
                menuPanelBounds[2],
                menuPanelBounds[3]
        );

        JButton replay = new JButton();
        {
            replay.setVisible(true);
            replay.setOpaque(false);
            replay.setContentAreaFilled(false);
            replay.setBorderPainted(true);
            Image replayUrl = new ImageIcon("src\\main\\resources\\infoPanel\\replay.png")
                    .getImage().getScaledInstance(
                            menuPanelBounds[2]/numberOfMenuButtons,
                            menuPanelBounds[3],
                            Image.SCALE_SMOOTH);
            replay.setIcon(new ImageIcon(replayUrl));
            replay.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                }
            });
        }
        add(replay);

        JButton rageQuit = new JButton();
        {
            rageQuit.setVisible(true);
            rageQuit.setOpaque(false);
            rageQuit.setContentAreaFilled(false);
            rageQuit.setBorderPainted(false);
            Image quitUrl = new ImageIcon("src\\main\\resources\\infoPanel\\quit.png")
                    .getImage().getScaledInstance(
                            menuPanelBounds[2]/numberOfMenuButtons,
                            menuPanelBounds[3],
                            Image.SCALE_SMOOTH);
            rageQuit.setIcon(new ImageIcon(quitUrl));
            rageQuit.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
            });
        }
        add(rageQuit);

    }
}
