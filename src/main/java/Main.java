import gui.*;

import javax.swing.*;
import java.awt.*;

import static gui.MainFrame.*;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MainFrame windowFrame = new MainFrame();
            windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windowFrame.setVisible(true);
        });
    }
}

