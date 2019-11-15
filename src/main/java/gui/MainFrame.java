package gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame /*implements FrontEndable*/ {

    private static Toolkit kit = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = kit.getScreenSize();
    private static int tile_x = screenSize.width;
    private static int tile_y = screenSize.height;


    public MainFrame() throws HeadlessException {
        setResizable(false);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setBackground(new Color(140, 192, 40));
        add(setLeftPanel());
        pack();
    }

    //    @Override
    public JPanel setLeftPanel() {
        JPanel leftPanel = new JPanel();
        MigLayout layout = new MigLayout();
        leftPanel.setLayout(layout);


        return leftPanel;
    }

/*    @Override
    public JPanel setRightPanel() {
        return null;
    }*/

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(tile_x, tile_y);
    }
}