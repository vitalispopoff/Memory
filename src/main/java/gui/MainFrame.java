package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame /*implements FrontEndable*/ {

    private static Toolkit kit = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = kit.getScreenSize();
    public static int tile_x = screenSize.width;
    public static int tile_y = screenSize.height;
    public static int tile = Integer.min(tile_x, tile_y);
    static JPanel mainPanel;
//    static JPanel leftPanel;
    static JPanel rightPanel;

    public MainFrame() throws HeadlessException {
        setResizable(false);
        MainPanel.MainPanel();

        add(mainPanel);
        mainPanel.add(new LeftPanel());
        mainPanel.add(new RightPanel());
//        mainPanel.add(LeftPanel());
//        mainPanel.add(RightPanel());
        pack();
        setVisible(true);
    }

    /*@Override*/
    public static JPanel MainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        return mainPanel;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(tile_x, tile_y);
    }

    static Border blackBorder(){
        return BorderFactory.createLineBorder(new Color(128, 128, 128, 128), 1);
    }
}

/*
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
}*/     // BS disposable
