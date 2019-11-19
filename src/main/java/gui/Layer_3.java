package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static gui.MainFrame.*;

public class Layer_3 {

    private static JPanel panel3;
    private static JPanel panel3Left = new JPanel();
    private static JPanel panel3Right = new JPanel();
    private static JPanel[] panel3List = new JPanel[]{panel3Left, panel3Right};
    int[] panel3LeftBounds = {
            tile >> 5,
            tile >> 5,
            tile_x - (tile_x >> 2) - (tile >> 3) - (tile >> 5),
            tile_y - (tile >> 3) + (tile >> 5)
    };
    int[] panel3RightBounds = {
            tile_x - (tile_x >> 2) - (tile >> 3),
            tile >> 5,
            (tile_x >> 2) + (tile >> 3),
            tile_y - (tile >> 3) + (tile >> 5)
    };
    private static String coverImageFileAddress = "src\\main\\resources\\transparent.png";

    public Layer_3() {
        panel3 = new JPanel();
        panel3.setOpaque(false);
        panel3.setBounds(0, 0, tile_x, tile_y);
        panel3.setLayout(null);

        {
            panel3Left.setBounds(panel3LeftBounds[0], panel3LeftBounds[1], panel3LeftBounds[2], panel3LeftBounds[3]);
            panel3Left.setLayout(new GridLayout(cardGridSize[0], cardGridSize[1]));
            panel3Left.setOpaque(false);
            makeCardButtons();
            panel3.add(panel3Left);
        }   //panel3Left    : lewy panel (buttons)

        {
            panel3Right.setBounds(panel3RightBounds[0], panel3RightBounds[1], panel3RightBounds[2], panel3RightBounds[3]);
            panel3Right.setLayout(null);
            panel3Right.setOpaque(false);
//            panel3Right.setBackground(new Color(255, 0, 255, 64));
            panel3.add(panel3Right);
        }   //panel3Right   : prawy panel (buttons)
    }   //layer1: panel3: graphics

    public static JPanel makeLayer_3() {
        new Layer_3();
        return panel3;
    }

    public void makeCardButtons() {
        Random random = new Random();

        for (int i = 0; i < cardGridSize[0] * cardGridSize[1]; i++) {
//            Image image = new ImageIcon(coverImageFileAddress).getImage().getScaledInstance(panel3LeftBounds[2]/cardGridSize[0], panel3LeftBounds[3]/cardGridSize[1], Image.SCALE_FAST);
            JButton button = new JButton();
            button.setOpaque(true);
            button.setContentAreaFilled(false);
            button.setBorderPainted(true);
            panel3Left.add(button);
            leftPanelButtons.add(button);
        }

    }

}
