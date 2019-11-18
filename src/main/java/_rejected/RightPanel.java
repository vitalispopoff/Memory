package _rejected;

import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static _rejected.MainFrame.*;

public class RightPanel extends JPanel{

    public RightPanel(){
        setRightPanel(this);
    }


    /*@Override*/
    public static void setRightPanel(RightPanel rightPanel) {
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

    }

    void populatePanel(){
        ArrayList<JPanel> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new JPanel());
//            rightPanel.add(list.get(i), "wrap");  //temporal
        }
    }
}
