package gui;

import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame /*implements FrontEndable*/ {

    private static Toolkit kit = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = kit.getScreenSize();
    public static int tile_x = screenSize.width;
    public static int tile_y = screenSize.height;
    public static int tile = Integer.min(tile_x, tile_y);
    static JPanel mainPanel;
    static JPanel leftPanel;
    static JPanel rightPanel;

    public MainFrame() throws HeadlessException {
        setResizable(false);
        MainPanel.MainPanel();

        add(mainPanel);
        mainPanel.add(LeftPanel());
        mainPanel.add(RightPanel());
        pack();
        setVisible(true);
    }

    /*@Override*/
    public static JPanel MainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
//        mainPanel.setBackground(new Color(255, 255, 0));

        return mainPanel;
    }

    /*@Override*/
    public JPanel LeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setBounds(
                tile >> 5,
                tile >> 5,
                tile_x - (tile_x >> 2) - (tile >> 3),
                tile_y - (tile >> 3) + (tile >> 5));
        leftPanel.setBackground(new Color(64, 192, 255));
        MigLayout Layout = new MigLayout();
        leftPanel.setLayout(Layout);
        return leftPanel;
    }

    /*@Override*/
    public JPanel RightPanel() {
        rightPanel = new JPanel();
        rightPanel.setBounds(
                tile_x - (tile_x >> 2) - (tile >> 3),
                tile >> 5,
                (tile_x >> 2) + (tile >> 3) - (tile >> 7),
                tile_y - (tile >> 3) + (tile >> 5));
        rightPanel.setBackground(new Color(192, 64, 255));
        LC lc = new LC();
        lc.setTopToBottom(true);
        MigLayout Layout = new MigLayout(lc);
        rightPanel.setLayout(Layout);
        ArrayList<JPanel> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new JPanel());
            rightPanel.add(list.get(i), "wrap");
        }
        return rightPanel;
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(tile_x, tile_y);
    }
}

class ImageComponent extends JComponent{
    private Image image;

    public ImageComponent(){
        image = new ImageIcon("clothImage.png").getImage();
    }

    public void paintComponent(Graphics graphics){
        if (image==null) return;

        graphics.drawImage(image, 0, 0, null);
        for (int i = 0; i < MainFrame.tile_x; i+=240) {
            for (int j = 0; j < MainFrame.tile_y; j+=240) {
                if(i+j >0)graphics.copyArea(0,0, 240, 240, i*240, j*240);
            }
        }

    }
}