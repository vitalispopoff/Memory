package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static gui.MainFrame.*;

public class Layer_2 {

    private static JPanel panel2;
    private static JPanel panel2Left = new JPanel();
    private static JPanel panel2Right = new JPanel();
    private static JPanel[] panel2List = new JPanel[]{panel2Left, panel2Right};
    int[] panel2LeftBounds = {
            tile >> 5,
            tile >> 5,
            tile_x - (tile_x >> 2) - (tile >> 3) - (tile >> 5),
            tile_y - (tile >> 3) + (tile >> 5)
    };
    int[] panel2RightBounds = {
            tile_x - (tile_x >> 2) - (tile >> 3),
            tile >> 5,
            (tile_x >> 2) + (tile >> 3),
            tile_y - (tile >> 3) + (tile >> 5)
    };

    public Layer_2() {
        panel2 = new JPanel();
        panel2.setOpaque(false);
        panel2.setBounds(0, 0, tile_x, tile_y);
        panel2.setLayout(null);

        {
//            panel2Left = new JPanel();
            panel2Left.setBounds(panel2LeftBounds[0], panel2LeftBounds[1], panel2LeftBounds[2], panel2LeftBounds[3]);
//                panel2Left.setLayout();
            panel2Left.setOpaque(true);
            panel2Left.setBackground(new Color(255, 255, 0, 64));
            panel2.add(panel2Left);
        }   //panel2Left    : lewy panel (buttons)

        {
//            panel2Right = new JPanel();
            panel2Right.setBounds(panel2RightBounds[0], panel2RightBounds[1], panel2RightBounds[2], panel2RightBounds[3]);
            panel2Right.setLayout(null);
            panel2Right.setOpaque(true);
            panel2Right.setBackground(new Color(255, 0, 255, 64));
            panel2.add(panel2Right);
        }   //panel2Right   : prawy panel (buttons)
    }   //layer1: panel2: graphics

    public static JPanel makeLayer_2() {
        new Layer_2();
        return panel2;
    }

    public void /*ArrayList<JButton>*/ makeCardButtons() {


    }

}
