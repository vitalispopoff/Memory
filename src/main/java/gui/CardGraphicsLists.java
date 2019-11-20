package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CardGraphicsLists {

    private List<Image> frontImagesList = new ArrayList<>();
    private List<Image> coverImagesList = new ArrayList<>();
    private String frontName = "src\\main\\resources\\cardFront";
    private String coverName = "src\\main\\resources\\cardCover";


    public CardGraphicsLists() {
        for (int i = 0; i <4 ; i++) {
            coverImagesList.add(new ImageIcon(new String(coverName.concat(Integer.toString(i))).concat(".png")).getImage());
        }

        for (int i = 0; i < 31 ; i++) {
            frontImagesList.add(new ImageIcon(new String(frontName.concat(Integer.toString(i))).concat(".png")).getImage());
        }
    }

    public List<Image> getFrontImagesList() {
        return frontImagesList;
    }

    public void setFrontImagesList(List<Image> frontImagesList) {
        this.frontImagesList = frontImagesList;
    }

    public List<Image> getCoverImagesList() {
        return coverImagesList;
    }

    public void setCoverImagesList(List<Image> backImagesList) {
        this.coverImagesList = backImagesList;
    }
}
