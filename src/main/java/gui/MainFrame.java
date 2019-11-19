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
    private int[] deckNumber = {8, 6};
    public ArrayList<JButton> leftPanelButtons = new ArrayList<>();
    //    private static JPanel panel0;     // TODO out
//    private static JPanel panel1;     // TODO out
    private static JPanel panel2;

    public void setDeckNumber(int[] deckNumber) {
        this.deckNumber = deckNumber;
    }

    public MainFrame() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(640, 480));
        /*JPanel */
//        panel0 = new JPanel();        //TODO out
        layeredPane.add(Layer_0.makeLayer_0(), new Integer(0));
        /*JPanel*/
//        panel1 = new JPanel();
        layeredPane.add(Layer_1.makeLayer_1(), new Integer(1));
        /*JPanel*/
//        panel2 = new JPanel();
        layeredPane.add(Layer_2.makeLayer_2(), new Integer(2));
        add(layeredPane);
    }
        /*{
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
        }*/   //layer0: panel0: background  : moved to Layer_0 class

        /*{
            panel1.setOpaque(false);

            panel1.setBounds(0, 0, tile_x, tile_y);
            panel1.setLayout(null);

            {
                JPanel panel1Left = new JPanel();
                int[] panel1LeftBounds = {
                        tile >> 5,
                        tile >> 5,
                        tile_x - (tile_x >> 2) - (tile >> 3) - (tile >> 5),
                        tile_y - (tile >> 3) + (tile >> 5)
                };
                panel1Left.setBounds(
                        panel1LeftBounds[0],
                        panel1LeftBounds[1],
                        panel1LeftBounds[2],
                        panel1LeftBounds[3]
                );
                panel1Left.setLayout(null);
                panel1Left.setOpaque(true);
                panel1Left.setBackground(new Color(255, 255, 0, 64));
                panel1.add(panel1Left);
            }   //panel1Left    : lewy panel (graphics)   disabled

            {
                JPanel panel1Right = new JPanel();
                panel1Right.setBounds(
                        tile_x - (tile_x >> 2) - (tile >> 3),
                        0,
                        (tile_x >> 2) + (tile >> 3),
                        tile_y);
                panel1Right.setLayout(null);
                panel1Right.setOpaque(true);
                String fileAddress = "src\\main\\resources\\noteSheet.png";
                Image sheet = new ImageIcon(fileAddress).getImage().getScaledInstance((tile_x >> 2) + (tile >> 3), tile_y, Image.SCALE_SMOOTH);
                JLabel label = new JLabel(new ImageIcon(sheet));
                label.setBounds(0, 0, (tile_x >> 2) + (tile >> 3), tile_y);
                panel1Right.add(label);
                panel1.add(panel1Right);
            }   //panel1Right   : prawy panel (graphics)    disabled

        }*/   //layer1: panel1: graphics    : moved to Layer_1 class

//        populatePanel2();
//    }

    /*{
//            JPanel panel2 = new JPanel();
        panel2.setOpaque(false);

        panel2.setBounds(0, 0, tile_x, tile_y);
        panel2.setLayout(null);

            {
                JPanel panel2Left = new JPanel();
                int[] panel2LeftBounds = {
                        tile >> 5,
                        tile >> 5,
                        tile_x - (tile_x >> 2) - (tile >> 3) - (tile >> 5),
                        tile_y - (tile >> 3) + (tile >> 5)
                };
                panel2Left.setBounds(
                        panel2LeftBounds[0],
                        panel2LeftBounds[1],
                        panel2LeftBounds[2],
                        panel2LeftBounds[3]
                );
//                panel2Left.setLayout();
                panel2Left.setOpaque(true);
                panel2Left.setBackground(new Color(255, 255, 0, 64));
                panel2.add(panel2Left);
            }   //panel2Left    : lewy panel (buttons)

            {
                JPanel panel2Right = new JPanel();
                panel2Right.setBounds(
                        tile_x - (tile_x >> 2) - (tile >> 3),
                        tile >> 5,
                        (tile_x >> 2) + (tile >> 3),
                        tile_y - (tile >> 3) + (tile >> 5));
                panel2Right.setLayout(null);
                panel2Right.setOpaque(true);
                panel2Right.setBackground(new Color(255, 0, 255, 64));
                panel2.add(panel2Right);
            }   //panel2Right   : prawy panel (buttons)

    }*/   //layer1: panel2: graphics

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
