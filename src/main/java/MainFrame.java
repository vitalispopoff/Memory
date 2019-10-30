
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private int tile;


    MainFrame(int tile) throws HeadlessException {
        this.tile = tile;
        setLocation(50, 50);
        setResizable(false);

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 11 * tile, 9 * tile);
        leftPanel.setBackground(Color.GREEN);
        add(leftPanel);
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(12 * tile, 0, 5 * tile, 9 * tile);
        rightPanel.setBackground(Color.ORANGE);
        add(rightPanel);
        pack();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(16 * tile, 9 * tile);
    }
}