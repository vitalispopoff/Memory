package gra.memory.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class CardGraphicsList implements CardGraphicsListing {

    private List<Image> frontImagesList = new ArrayList<>();

    CardGraphicsList() {

        for (int i = 0; i < 31; i++) {
            frontImagesList.add(new ImageIcon(
                    "src\\main\\resources\\cardFront"
                            .concat(Integer.toString(i))
                            .concat(".png"))
                    .getImage());
        }
    }
    List<Image> getFrontImagesList() {
        return frontImagesList;
    }
}
