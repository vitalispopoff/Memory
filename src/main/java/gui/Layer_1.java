package gui;

import javax.swing.*;

import java.awt.*;

import static gui.MainFrame.*;

public class Layer_1 {

    public static JPanel panel1;
    public static JPanel[] panel1List;
    private static JPanel panel1Left;
    private static JPanel panel1Right;
    private static String fileAddress = "src\\main\\resources\\noteSheet.png";
    private static int[] panel1LeftBounds = {
            tile >> 5,
            tile >> 5,
            tile_x - (tile_x >> 2) - (tile >> 3) - (tile >> 5),
            tile_y - (tile >> 3) + (tile >> 5)
    };
    private static int[] panel1RightBounds = {
            tile_x - (tile_x >> 2) - (tile >> 3),
            0,
            (tile_x >> 2) + (tile >> 3),
            tile_y
    };

    public Layer_1() {
        panel1 = new JPanel();
        panel1.setOpaque(false);

        panel1.setBounds(0, 0, tile_x, tile_y);
        panel1.setLayout(null);

/*        {
            JPanel panel1Left = new JPanel();
            panel1Left.setBounds(panel1LeftBounds[0], panel1LeftBounds[1], panel1LeftBounds[2], panel1LeftBounds[3]);
            panel1Left.setLayout(null);
            panel1Left.setOpaque(true);
            panel1Left.setBackground(new Color(255, 255, 0, 64));
            panel1.add(panel1Left);
        }*/   //panel1Left    : lewy panel (graphics)   disabled

        {
            JPanel panel1Right = new JPanel();
            panel1Right.setBounds(panel1RightBounds[0], panel1RightBounds[1], panel1RightBounds[2], panel1RightBounds[3]);
            panel1Right.setLayout(null);
            panel1Right.setOpaque(true);

            Image sheet = new ImageIcon(fileAddress).getImage().getScaledInstance(panel1RightBounds[2], panel1LeftBounds[3], Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(sheet));
            label.setBounds(panel1RightBounds[0], panel1RightBounds[1], panel1RightBounds[2], panel1LeftBounds[3]);
//            panel1Right.add(label);
//            panel1.add(panel1Right);
            panel1.add(panel1Right.add(label));
        }   //panel1Right   : prawy panel (graphics)    disabled
    }   //layer1: panel1: graphics

    public static JPanel makeLayer_1() {
        new Layer_1();
        panel1List = new JPanel[]{panel1Left, panel1Right};
        return panel1;
    }
}
