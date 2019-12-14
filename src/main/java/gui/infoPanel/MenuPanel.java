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

        JButton restart = new JButton();
        {
/*            restart.setBounds(
                    0,
                    0,
                    (menuPanelBounds[2]>>2)+(menuPanelBounds[2]>>3),
                    menuPanelBounds[3]-(menuPanelBounds[3]>>2)
            );*/
            restart.setOpaque(true);
            restart.setBackground(new Color(255, 255, 0, 128));   // TODO $%^
            restart.setVisible(true);
            Image quitUrl = new ImageIcon("src\\main\\resources\\infoPanel\\restart.png")
                    .getImage().getScaledInstance(
                            menuPanelBounds[2]/numberOfMenuButtons,
                            menuPanelBounds[3]/numberOfMenuButtons,
                            Image.SCALE_SMOOTH);
            restart.setIcon(new ImageIcon(quitUrl));

            restart.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
//                    System.exit(0);
                }
            });
        }

        JButton rageQuit = new JButton();
        {
/*            rageQuit.setBounds(
                    0,
                    0,
                    (menuPanelBounds[2]>>2)+(menuPanelBounds[2]>>3),
                    menuPanelBounds[3]-(menuPanelBounds[3]>>2)
            );*/
            rageQuit.setOpaque(true);
            rageQuit.setBackground(new Color(255, 255, 0, 128));   // TODO $%^
            rageQuit.setVisible(true);
            Image quitUrl = new ImageIcon("src\\main\\resources\\infoPanel\\restart.png")
                    .getImage().getScaledInstance(
                            menuPanelBounds[2]/numberOfMenuButtons,
                            menuPanelBounds[3]/numberOfMenuButtons,
                            Image.SCALE_SMOOTH);
            rageQuit.setIcon(new ImageIcon(quitUrl));

            rageQuit.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
            });
        }
        add(restart);
        add(rageQuit);



    }


}
