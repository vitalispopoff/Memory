package gra.memory.gui.infoPanel;

import javax.swing.*;
import java.awt.*;

import gra.memory.gui.TemporalParent;

public class GameHeadline extends TemporalParent {

    public GameHeadline() {
        super();
        setLayout(null);
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
            Font bannerFont = cowboyjunkDEMO.deriveFont((float) (headlinePanelBounds[3] >> 1));
            panelHeadline.setFont(bannerFont);
            panelHeadline.setHorizontalTextPosition(SwingConstants.CENTER);
            panelHeadline.setText("MEMORY");
        }
        add(panelHeadline);
    }
}
