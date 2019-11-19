package gui;

import javax.swing.*;
import java.util.Random;

import static gui.MainFrame.*;

public class Layer_0 /*extends JPanel */{

    private static JPanel panel0;
    private static String addressTree = "src\\main\\resources\\mainBackground.png";
    private static int imageDimension = 240;
    private static int bcgImageNumber = 4;

    public Layer_0() {
        panel0 = new JPanel();
        panel0.setBounds(0, 0, tile_x, tile_y);
        panel0.setLayout(null);
//        String addressTree = "src\\main\\resources\\mainBackground.png";
        Random random = new Random();

        for (int i = 0; i < tile_x; i += imageDimension) {
            for (int j = 0; j < tile_y; j += imageDimension) {
                Integer fileNumber = random.nextInt(bcgImageNumber);
                String fileAddress = addressTree.replace(
                        addressTree.substring(addressTree.length() - 4,
                                addressTree.length() - 3),
                        (Integer.toString(fileNumber) + "."));
                JLabel label = new JLabel(new ImageIcon(new ImageIcon(fileAddress).getImage()));
                label.setBounds(i, j, imageDimension, imageDimension);
                panel0.add(label);
            }
        }
    }

    public static JPanel makeLayer_0(){
        new Layer_0();
        return panel0;
    }
}
