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
        }   //layer0: panel0: background

        {
            JPanel panel1 = new JPanel();
            panel1.setOpaque(false);
            layeredPane.add(panel1, new Integer(1));
            panel1.setBounds(0, 0, tile_x, tile_y);
            panel1.setLayout(null);

            {
                JPanel panel1Left = new JPanel();
                panel1Left.setBounds(
                        tile >> 5,
                        tile >> 5,
                        tile_x - (tile_x >> 2) - (tile >> 3) - (tile >> 5),
                        tile_y - (tile >> 3) + (tile >> 5));
                panel1Left.setLayout(null);
                panel1Left.setOpaque(true);
                panel1Left.setBackground(new Color(255, 255, 0, 64));
                panel1.add(panel1Left);
            }   //panel1Left    : lewy panel (graphics)
            {
                JPanel panel1Right = new JPanel();
                panel1Right.setBounds(
                        tile_x - (tile_x >> 2) - (tile >> 3),
                        tile >> 5,
                        (tile_x >> 2) + (tile >> 3),
                        tile_y - (tile >> 3) + (tile >> 5));
                panel1Right.setLayout(null);
                panel1Right.setOpaque(true);
                panel1Right.setBackground(new Color(255, 0, 255, 64));
                panel1.add(panel1Right);
            }   //panel1Right   : prawy panel (graphics)
            
        }   //layer1: panel1: graphics

//        TODO : //layer2: panel2: infos (txts)

        {
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

        }   //layer1: panel3: interactions
        
        
        

        add(layeredPane);
    }

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
