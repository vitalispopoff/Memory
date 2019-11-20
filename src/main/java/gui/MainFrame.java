package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class MainFrame extends JPanel {

    private static String gameIconImage = "src\\main\\resources\\gameIcon.png";
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
        layeredPane.add(Layer_0.makeLayer_0(), new Integer(0));     // *    background (graphics only)
        layeredPane.add(Layer_1.makeLayer_1(), new Integer(1));     // *    panels  (graphics only)
        layeredPane.add(Layer_2.makeLayer_2(), new Integer(2));     // *    panel right - (writings - graphics)
        layeredPane.add(Layer_3.makeLayer_3(), new Integer(3));     // *    panels  (interactions)
        add(layeredPane);
    }

    public static void createAndShowGUI() {

        JFrame frame = new JFrame();
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new MainFrame();
        newContentPane.setOpaque(true);
        frame.setIconImage(new ImageIcon(gameIconImage).getImage());
        frame.setTitle("Memory");
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(tile_x, tile_y);
    }
}

//      TODO : fullscreen
