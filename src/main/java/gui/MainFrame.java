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

    private JLayeredPane layeredPane;
    private ArrayList<JLabel> labelList = new ArrayList<>();
    private ArrayList<JPanel> panelList = new ArrayList<>();

    public MainFrame() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(640, 480));

        for (int i = 0; i < 5; i++) {
            JPanel panel = new JPanel();
            panel.add(new JLabel());
            panel.setOpaque(false);
            panel.setBounds(0, 0, 0, 0);
            layeredPane.add(panel, new Integer(i));
            panelList.add(panel);
        }
        add(layeredPane);
//        GridLayout bcgLayout = new GridLayout(640 / 240, 480 / 240);
//        bcgLayout.setVgap(0);
        panelList.get(0).setBounds(0, 0, 640, 480);
        panelList.get(0).setLayout(null);
        for (int i = 0; i < 640; i += 240) {
            for (int j = 0; j < 480; j += 240) {
                JLabel label = new JLabel(new ImageIcon(new ImageIcon("src\\main\\resources\\clothTile.png").getImage()));
                label.setBounds(i, j, 240, 240);
                panelList.get(0).add(label);
            }
        }
        panelList.get(1).setBounds(0, 0, 640, 480);
        panelList.get(1).add(new JLabel(new ImageIcon(new ImageIcon("src\\main\\resources\\gif-fail-plane-737408.gif").getImage())));


        panelList.get(4).setBounds(0, 0, 640, 480);
        panelList.get(4).setLayout(null);
        for (int i = 0; i < 640; i += 32) {
            for (int j = 0; j < 480; j += 32) {
                JButton button = new JButton();
                button.setBounds(i, j, 32, 32);
                button.setOpaque(true);
                button.setContentAreaFilled(false);
                button.setBorderPainted(true);
                panelList.get(4).add(button);
            }
        }
    }

    public static void createAndShowGUI() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new MainFrame();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(tile_x, tile_y);
    }
}
