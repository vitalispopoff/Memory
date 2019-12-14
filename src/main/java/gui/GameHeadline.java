package gui;

import javax.swing.*;

import java.awt.*;

import static gui.BackgroundPanel.*;

public class GameHeadline extends JPanel {

    private static int[] headlinePanelBounds = {
            (tile_x >> 1) + (tile_x >> 2) - (tile_x >> 5),
            tile_y >> 3,
            (tile_x >> 2) + (tile_x >> 6),
            ((tile_x >> 2) + (tile_x >> 6)) * 226 / 910,
    };

    GameHeadline() {
        setLayout(null);
        setOpaque(false);
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
            panelHeadline.setOpaque(false);
            panelHeadline.setVisible(true);

            Image panelHeadlineUrl = new ImageIcon("src\\main\\resources\\infoPanel\\memory.png")
                    .getImage().getScaledInstance(
                            headlinePanelBounds[2],
                            headlinePanelBounds[3],
                            Image.SCALE_SMOOTH);
            panelHeadline.setIcon(new ImageIcon(panelHeadlineUrl));
        }
        add(panelHeadline);
    }
}
