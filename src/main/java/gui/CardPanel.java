package gui;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

    String fileAddress = "src\\main\\resources\\cardCover.png";

    int[] cardPanelBounds = {MainFrame.tile >> 5,
            MainFrame.tile >> 5,
            (MainFrame.tile_x >> 1) + (MainFrame.tile_x >> 3),
            MainFrame.tile_y - (MainFrame.tile >> 4)};

    int[] cardPanelGridDimensions = {7, 8};

    int[] cardPanelGridSizes = {
            cardPanelBounds[2] / cardPanelGridDimensions[0],
            cardPanelBounds[3] / cardPanelGridDimensions[1]};
    int cardSize;

    {
        int cache = Integer.min(cardPanelGridSizes[0], cardPanelGridSizes[0]);
        cardSize = cache - (cache >> 2);
    }   //  * cardSize definition

    public CardPanel() {
        super();

        setLayout(new GridLayout(
                cardPanelGridDimensions[0],
                cardPanelGridDimensions[1]));

        setBounds(
                cardPanelBounds[0],
                cardPanelBounds[1],
                cardPanelBounds[2],
                cardPanelBounds[3]);

        setOpaque(false);

        for (int i = 0; i < 56; i++) {
            JButton button = new JButton();
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);

            Image sheet = new ImageIcon(fileAddress).getImage().getScaledInstance(
                    cardSize,
                    cardSize,
                    Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(sheet));
            add(button);
        }


    }
}
