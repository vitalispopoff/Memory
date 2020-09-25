package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class CardGraphicsList implements CardGraphicsListing {

	private static final String
		catalog = "src\\main\\resources\\cardFront",
		extension = ".png";

	private final List<Image>
		frontImageList = new ArrayList<>();



	CardGraphicsList() {

		for (int i = 0; i < 31; i++) {

			frontImageList.add(new ImageIcon(catalog + i + extension).getImage());
		}
	}



	List<Image> getFrontImageList() {

		return frontImageList;
	}
}