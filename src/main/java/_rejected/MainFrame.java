package _rejected;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame /*implements FrontEndable*/ {

    private static Toolkit kit = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = kit.getScreenSize();
    public static int tile_x = screenSize.width;
    public static int tile_y = screenSize.height;
    public static int tile = Integer.min(tile_x, tile_y);
    MainLayeredPane mainLayeredPane;
//    static JPanel mainPanel;
//    static JPanel leftPanel;
//    static JPanel rightPanel;

    public MainFrame() throws HeadlessException {
        setResizable(false);
        add (new MainLayeredPane());
        pack();



//        MainPanel.MainPanel();
//        add(mainPanel);

//        mainPanel.add(new LeftPanel());
//        mainPanel.add(new RightPanel());


        setVisible(true);
    }






/*    public static JPanel MainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        return mainPanel;
    }*/

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(tile_x, tile_y);
    }

}


