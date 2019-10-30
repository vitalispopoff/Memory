import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MainFrame windowFrame = new MainFrame(40);
            windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windowFrame.setVisible(true);
        });
    }
}
