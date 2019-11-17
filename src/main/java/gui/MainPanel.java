package gui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends MainFrame /*implements FrontEndable*/{

//    private static String textureAdress = "resources\\clothTile.png";

        /*@Override*/
    public static JPanel MainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        addTexture();
//        mainPanel.setBackground(new Color(255, 255, 0));
        return mainPanel;
    }

    static void addTexture(){
        JLabel label = new JLabel(new ImageIcon(new ImageIcon("f:\\star.gif").getImage()));
        mainPanel.add(label);
    }

}
