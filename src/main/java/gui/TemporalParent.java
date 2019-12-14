package gui;

import javax.swing.*;
import java.awt.*;

import static gui.infoPanel.MenuPanel.*;

public abstract class TemporalParent extends JPanel {

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static int tile_x = screenSize.width;
    static int tile_y = screenSize.height + 5;
    static int tile = Integer.min(tile_x, tile_y);

    public static int[] cardPanelBounds = {
            tile >> 5,
            tile >> 5,
            (tile_x >> 1) + (tile_x >> 3),
            tile_y - (tile >> 4)
    };

    public static int[] infoPanelBounds = {
            (tile_x >> 1) + (tile_x >> 2) - (tile_x >> 5),
            tile_y >> 3,
            (tile_x >> 2) + (tile_x >> 6),
            tile_y - (tile_y >> 2) + (tile_y >> 5)
    };

    public static int[] headlinePanelBounds = {
            infoPanelBounds[0],
            infoPanelBounds[1],
            infoPanelBounds[2],
            (infoPanelBounds[2] >> 2) + (infoPanelBounds[2] >> 4)
    };

    public static int[] menuPanelBounds = {
            infoPanelBounds[0],
            infoPanelBounds[3],
            infoPanelBounds[2],
            (infoPanelBounds[2] >> 2)-(infoPanelBounds[2]>>4)
    };


}
