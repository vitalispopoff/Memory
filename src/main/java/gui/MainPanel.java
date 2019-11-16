package gui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends MainFrame /*implements FrontEndable*/{
    

        /*@Override*/
    public static JPanel MainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
//        mainPanel.setBackground(new Color(255, 255, 0));

        return mainPanel;
    }

}
