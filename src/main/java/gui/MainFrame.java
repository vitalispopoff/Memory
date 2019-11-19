package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JPanel {

    private static Toolkit kit = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = kit.getScreenSize();
    public static int tile_x = screenSize.width;
    public static int tile_y = screenSize.height;
    public static int tile = Integer.min(tile_x, tile_y);
    public static int[] cardGridSize = {8, 7};
    public static ArrayList<JButton> leftPanelButtons = new ArrayList<>();
    private JLayeredPane layeredPane;

    private static JPanel panel2;

    public void setCardGridSize(int[] cardGridSize) {
        this.cardGridSize = cardGridSize;
    }

    public MainFrame() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        layeredPane = new JLayeredPane();
//        layeredPane.setPreferredSize(new Dimension(640, 480));
        layeredPane.add(Layer_0.makeLayer_0(), new Integer(0));
        layeredPane.add(Layer_1.makeLayer_1(), new Integer(1));
        layeredPane.add(Layer_2.makeLayer_2(), new Integer(2));
        add(layeredPane);
    }

        /*{
            JPanel panel3 = new JPanel();
            panel3.setOpaque(false);
            layeredPane.add(panel3, new Integer(1));
            panel3.setBounds(0, 0, tile_x, tile_y);
            panel3.setLayout(null);

            {
                JPanel panel3Left = new JPanel();
                panel3Left.setBounds(
                        tile >> 5,
                        tile >> 5,
                        tile_x - (tile_x >> 2) - (tile >> 3) - (tile >> 5),
                        tile_y - (tile >> 3) + (tile >> 5));
                panel3Left.setLayout(null);
                panel3Left.setOpaque(true);
                panel3Left.setBackground(new Color(255, 255, 0, 64));
                panel3.add(panel3Left);
            }   //panel3Left    : lewy panel (graphics)

            {
                JPanel panel3Right = new JPanel();
                panel3Right.setBounds(
                        tile_x - (tile_x >> 2) - (tile >> 3),
                        tile >> 5,
                        (tile_x >> 2) + (tile >> 3),
                        tile_y - (tile >> 3) + (tile >> 5));
                panel3Right.setLayout(null);
                panel3Right.setOpaque(true);
                panel3Right.setBackground(new Color(255, 0, 255, 64));
                panel3.add(panel3Right);
            }   //panel3Right   : prawy panel (graphics)

        }*/   //layer3:   interactions


    public static void createAndShowGUI() {

        JFrame frame = new JFrame();
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new MainFrame();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(tile_x, tile_y);
    }
}
