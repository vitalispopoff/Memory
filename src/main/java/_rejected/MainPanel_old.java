package _rejected;

import javax.swing.*;
import java.util.Random;

public class MainPanel_old extends MainFrame /*implements FrontEndable*/ {

    static JLabel label;
//    private static String textureAdress = "resources\\clothTile.png";

    /*@Override*/
//    public static JPanel MainPanel() {
//        mainPanel = new JPanel();
//        mainPanel.setLayout(null);
//        addTexture();
//        mainPanel.setBackground(new Color(255, 255, 0));
//        return mainPanel;
//    }

/*    static void addTexture() {
        label = new JLabel(new ImageIcon(new ImageIcon("src\\main\\resources\\mainBackground0.png").getImage()));
        label.setSize(240, 240);
        mainPanel.add(label);
        for (int i = 0; i * MainFrame.tile_x <=0; i++) {

        }
    }*/

    static void addTexture() {

        String addressTree = "src\\main\\resources\\mainBackground.png";
        Random random = new Random();
        int imageDimension = 240;
        int bcgImageNumber = 4;
        for (int i = 0; i < MainFrame.tile_x; i += imageDimension) {
            for (int j = 0; j < MainFrame.tile_y; j += imageDimension) {

                Integer fileNumber = random.nextInt(bcgImageNumber);
                String fileAddress = addressTree.replace(addressTree.substring(addressTree.length() - 4, addressTree.length() - 3), (Integer.toString(fileNumber) + "."));

                JLabel label = new JLabel(new ImageIcon(new ImageIcon(fileAddress).getImage()));
                label.setBounds(i, j, imageDimension, imageDimension);
//                mainPanel.add(label);
            }
        }
    }
}