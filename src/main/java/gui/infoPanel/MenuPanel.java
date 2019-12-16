package gui.infoPanel;

import gui.TemporalParent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MenuPanel extends TemporalParent {

    public static int numberOfMenuButtons=2;

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
            Font replayFont = cowboyjunkDEMO.deriveFont((float) (menuPanelBounds[3]>>1));
            /*Image replayUrl = new ImageIcon("src\\main\\resources\\infoPanel\\replay.png")
                    .getImage().getScaledInstance(
                            menuPanelBounds[2]/numberOfMenuButtons,
                            menuPanelBounds[3],
                            Image.SCALE_SMOOTH);
            replay.setIcon(new ImageIcon(replayUrl));*/ //  (TODO) disposable ?
//            replay.setVisible(true);
//            replay.setOpaque(false);
            replay.setContentAreaFilled(false);
            replay.setBorderPainted(true);
            replay.setFont(replayFont);
            replay.setHorizontalTextPosition(SwingConstants.CENTER);
            replay.setText("REPLAY");
            
            replay.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                }
            });
        }
        JButton rageQuit = new JButton();
        {
/*            Image quitUrl = new ImageIcon("src\\main\\resources\\infoPanel\\quit.png")
                    .getImage().getScaledInstance(
                            menuPanelBounds[2]/numberOfMenuButtons,
                            menuPanelBounds[3],
                            Image.SCALE_SMOOTH);
            rageQuit.setIcon(new ImageIcon(quitUrl));*/ //  (TODO) disposable?
            Font quitFont = cowboyjunkDEMO.deriveFont((float) (menuPanelBounds[3]>>1));
//            rageQuit.setVisible(true);
//            rageQuit.setOpaque(false);
            rageQuit.setContentAreaFilled(false);
            rageQuit.setBorderPainted(false);
            rageQuit.setFont(quitFont);
            rageQuit.setHorizontalTextPosition(SwingConstants.CENTER);
            rageQuit.setText("QUIT");
            rageQuit.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
            });
        }
        add(replay);
        add(rageQuit);

    }
}
