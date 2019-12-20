package gra.memory.gui.infoPanel;

import gra.memory.gui.TemporalParent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends TemporalParent {

    public static int numberOfMenuButtons=2;

    public MenuPanel() {
        setLayout(new GridLayout(1,numberOfMenuButtons));
        setBounds(
                menuPanelBounds[0],
                menuPanelBounds[1],
                menuPanelBounds[2],
                menuPanelBounds[3]
        );
        JButton replay = new JButton();
        {
            Font replayFont = cowboyjunkDEMO.deriveFont((float) (menuPanelBounds[3]>>1));
            replay.setContentAreaFilled(false);
            replay.setBorderPainted(false);
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
            Font quitFont = cowboyjunkDEMO.deriveFont((float) (menuPanelBounds[3]>>1));
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
//        add(replay);
        add(rageQuit);
    }
}
