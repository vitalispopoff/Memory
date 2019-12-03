package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CardGraphicsLists {

    private List<Image> frontImagesList = new ArrayList<>();
    private String frontName = "src\\main\\resources\\cardFront";

    public CardGraphicsLists() {

        for (int i = 0; i < 31; i++) {
            frontImagesList.add(new ImageIcon(new String(frontName.concat(Integer.toString(i))).concat(".png")).getImage());
        }
    }

    public List<Image> getFrontImagesList() {
        return frontImagesList;
    }
}
