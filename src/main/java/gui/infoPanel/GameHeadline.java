package gui.infoPanel;

import javax.swing.*;
import java.awt.*;

import gui.TemporalParent;

public class GameHeadline extends TemporalParent {

    static Font bannerFont;


    public GameHeadline() {
        super();
        setLayout(null);
//        setOpaque(false);
        setBounds(
                headlinePanelBounds[0],
                headlinePanelBounds[1],
                headlinePanelBounds[2],
                headlinePanelBounds[3]
        );
        JLabel panelHeadline = new JLabel();
        {
            panelHeadline.setBounds(
                    0,
                    0,
                    headlinePanelBounds[2],
                    (headlinePanelBounds[2] * 226 / 910)
            );
            panelHeadline.setOpaque(true);
            panelHeadline.setVisible(true);
            panelHeadline.setBackground(new Color(255, 0, 255, 96));
/*
            Image panelHeadlineUrl = new ImageIcon("src\\main\\resources\\infoPanel\\memory.png")
                    .getImage().getScaledInstance(
                            headlinePanelBounds[2],
                            headlinePanelBounds[3],
                            Image.SCALE_SMOOTH);
//            panelHeadline.setIcon(new ImageIcon(panelHeadlineUrl));
            */  //      (TODO) disposable?
            bannerFont = cowboyjunkDEMO.deriveFont((float) (headlinePanelBounds[3] >> 1));

            panelHeadline.setFont(bannerFont);
            panelHeadline.setHorizontalTextPosition(SwingConstants.CENTER);
            panelHeadline.setText("MEMORY");
        }
        add(panelHeadline);
    }
}
