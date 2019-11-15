
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private int tile;


    MainFrame(int tile) throws HeadlessException {

//        setUndecorated(true);
        setVisible(true);
        this.tile = tile;
        setLocation(50, 50);
        setResizable(false);
        add( new JPanel());




/*        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 11 * tile, 9 * tile);
        leftPanel.setBackground(Color.GREEN);

        *//*        int x = 4;
        int y = 4;
        leftPanel.setLayout(new GridLayout(x,y));
        for (int i = 0; i <x*y ; i++) {
            leftPanel.add(new JButton());
        }*//*     // grid generator

        add(leftPanel);
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(12 * tile, 0, 5 * tile, 9 * tile);
        rightPanel.setBackground(Color.ORANGE);
        add(rightPanel);*/      // old version ; disposable
        pack();
    }

/*    @Override
    public Dimension getPreferredSize() {
        return new Dimension();
    }*/     //disposable
}