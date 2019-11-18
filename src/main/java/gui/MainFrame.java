package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MainFrame extends JPanel {

    private static Toolkit kit = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = kit.getScreenSize();
    public static int tile_x = screenSize.width;
    public static int tile_y = screenSize.height;
    public static int tile = Integer.min(tile_x, tile_y);

    private JLayeredPane layeredPane;
    private ArrayList<JLabel> labelList = new ArrayList<>();
    private ArrayList<JPanel> panelList = new ArrayList<>();
    private JPanel panel0;

    public MainFrame() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(640, 480));

//        for (int i = 0; i < 5; i++) {
//            JPanel panel = new JPanel();
//            panel.add(new JLabel());
//            panel.setOpaque(false);
//            layeredPane.add(panel, new Integer(i));
//            panelList.add(panel);
//        }
//        add(layeredPane);


        {
            JPanel panel0 = new JPanel();
            layeredPane.add(panel0, new Integer(0));
            panel0.setBounds(0, 0, tile_x, tile_y);
            panel0.setLayout(null);
            String addressTree = "src\\main\\resources\\mainBackground.png";
            Random random = new Random();
            int imageDimension = 240;
            int bcgImageNumber = 4;
            for (int i = 0; i < MainFrame.tile_x; i += imageDimension) {
                for (int j = 0; j < MainFrame.tile_y; j += imageDimension) {
                    Integer fileNumber = random.nextInt(bcgImageNumber);
                    String fileAddress = addressTree.replace(
                            addressTree.substring(addressTree.length() - 4,
                                    addressTree.length() - 3),
                            (Integer.toString(fileNumber) + "."));

                    JLabel label = new JLabel(new ImageIcon(new ImageIcon(fileAddress).getImage()));
                    label.setBounds(i, j, imageDimension, imageDimension);
                    panel0.add(label);
                }
            }
        }

        {
            JPanel panel1 = new JPanel();
            panel1.setOpaque(false);
            layeredPane.add(panel1, new Integer(1));
            panel1.setBounds(0, 0, tile_x, tile_y);
            panel1.setLayout(null);

            {
                JPanel panel1Left = new JPanel();
                panel1Left.setBounds(0, 0, tile_x >> 1, tile_y);
                panel1Left.setLayout(null);
                panel1Left.setOpaque(true);
                panel1Left.setBackground(new Color(255, 255, 0, 64));
                panel1.add(panel1Left);
            }
            JPanel panel1right = new JPanel();
            panel1right.setBounds(tile_x>>1, 0, tile_x>>1, tile_y);
            panel1right.setLayout(null);
            panel1right.setOpaque(true);
            panel1right.setBackground(new Color(255,0,255,64));
            panel1.add(panel1right);
        }


        add(layeredPane);
//        panelList.get(1).setBounds(0, 0, tile_x, tile_y);
//        panelList.get(1).add(new JLabel(new ImageIcon(new ImageIcon("src\\main\\resources\\gif-fail-plane-737408.gif").getImage())));


//        panelList.get(4).setBounds(0, 0, tile_x, tile_y);
//        panelList.get(4).setLayout(null);
//        for (int i = 0; i < tile_x; i += 32) {
//            for (int j = 0; j < tile_y; j += 32) {
//                JButton button = new JButton();
//                button.setBounds(i, j, 32, 32);
//                button.setOpaque(true);
//                button.setContentAreaFilled(false);
//                button.setBorderPainted(true);
//                panelList.get(4).add(button);
//            }
//        }

    }

//    public MainFrame() {
//        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//
//        layeredPane = new JLayeredPane();
//        layeredPane.setPreferredSize(new Dimension(640, 480));
//
///*        for (int i = 0; i < 5; i++) {
//            JPanel panel = new JPanel();
//            panel.add(new JLabel());
//            panel.setOpaque(false);
//            panel.setBounds(0, 0, 0, 0);
//            layeredPane.add(panel, new Integer(i));
//            panelList.add(panel);
//        } //layer iteration
//
//      add(layeredPane);
//      */
//        panel0 = new JPanel();
//        panel0.setLayout(null);
//        panel0.setBounds(0, 0, tile_x, tile_y);
//        String addressTree = "src\\main\\resources\\mainBackground.png";
//        Random random = new Random();
//        int imageDimension = 240;
//        int bcgImageNumber = 4;
//
//        for (int i = 0; i < tile_x; i += imageDimension) {
//            for (int j = 0; j < tile_y; j += imageDimension) {
//
//                Integer fileNumber = random.nextInt(bcgImageNumber);
//                String fileAddress = addressTree.replace(addressTree.substring(addressTree.length() - 4, addressTree.length() - 3), (Integer.toString(fileNumber) + "."));
//
//                JLabel label = new JLabel(new ImageIcon(new ImageIcon(fileAddress).getImage()));
//                label.setBounds(i, j, imageDimension, imageDimension);
//                panel0.add(label);
//            }
//        }
//
//
//
//
// /*         panelList.get(0).setBounds(0, 0, 640, 480);
//        panelList.get(0).setLayout(null);
//        for (int i = 0; i < 640; i += 240) {
//            for (int j = 0; j < 480; j += 240) {
//                JLabel label = new JLabel(new ImageIcon(new ImageIcon("src\\main\\resources\\mainBackground0.png").getImage()));
//                label.setBounds(i, j, 240, 240);
//                panelList.get(0).add(label);
//            }
//        }*/ //layer0
//
//
///*        panelList.get(1).setBounds(0, 0, 640, 480);
//        panelList.get(1).add(new JLabel(new ImageIcon(new ImageIcon("src\\main\\resources\\gif-fail-plane-737408.gif").getImage())));*/ //layer1
//
//
///*        panelList.get(4).setBounds(0, 0, 640, 480);
//        panelList.get(4).setLayout(null);
//        for (int i = 0; i < 640; i += 32) {
//            for (int j = 0; j < 480; j += 32) {
//                JButton button = new JButton();
//                button.setBounds(i, j, 32, 32);
//                button.setOpaque(true);
//                button.setContentAreaFilled(false);
//                button.setBorderPainted(true);
//                panelList.get(4).add(button);
//            }
//        }*/ //layer4
//
//        add(layeredPane);
//    }

/*    void addTexture(JPanel panel) {
        String addressTree = "src\\main\\resources\\mainBackground.png";
        Random random = new Random();
        int imageDimension = 240;
        int bcgImageNumber = 4;
        for (int i = 0; i < MainFrame.tile_x; i += imageDimension) {
            for (int j = 0; j < MainFrame.tile_y; j += imageDimension) {

                Integer fileNumber = random.nextInt(bcgImageNumber);
                String fileAddress = addressTree.replace(addressTree.substring(addressTree.length() - 4, addressTree.length() - 3), (Integer.toString(fileNumber) + "."));

                JLabel label = new JLabel(new ImageIcon(new ImageIcon(fileAddress).getImage()));
                label.setBounds(i, j, imageDimension, imageDimension);
                panel.add(label);
            }
        }
    }*/

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
