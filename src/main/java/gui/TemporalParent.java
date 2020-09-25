package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static com.google.common.io.Resources.*;

public abstract class TemporalParent extends JPanel {

	private static final Dimension
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	static int
		tile_x = screenSize.width,
		tile_y = screenSize.height + 5,
		tile = Integer.min(tile_x, tile_y);

	public static int[]
		cardPanelBounds = {tile / 32, tile / 32, tile_x * 5 / 8, tile_y - (tile / 4)},
		infoPanelBounds = {tile_x * 23 / 32, tile_y / 8, tile_x * 17 / 64, tile_y * 25 / 32},
		headlinePanelBounds = {infoPanelBounds[0], infoPanelBounds[1], infoPanelBounds[2], infoPanelBounds[2] * 5 / 16},
		menuPanelBounds = {infoPanelBounds[0], infoPanelBounds[3], infoPanelBounds[2], infoPanelBounds[2] * 3 / 16},
		playerStatusPanelBounds = {infoPanelBounds[0], infoPanelBounds[1] + headlinePanelBounds[3], infoPanelBounds[2], infoPanelBounds[3] * 3 / 8};

	public static int
		numberOfPlayers = 2;

	public static Font
		headlines,
		handWritten,
		indicators;


	public TemporalParent() {

		setFonts();
		setOpaque(false);
		setVisible(true);
	}



	public static void setFonts() {

		try {

			handWritten = Font.createFont(Font.TRUETYPE_FONT, getResource("fonts\\Jandysdua.ttf").openStream());

/*
			Jandysdua = Font.createFont(
				Font.TRUETYPE_FONT, SecuritySupport.getResourceAsStream("fonts\\Jandysdua.ttf")
			);
*/

			headlines = Font.createFont(Font.TRUETYPE_FONT, getResource("fonts\\cowboyjunkDEMO.ttf").openStream());

/*
			cowboyjunkDEMO = Font.createFont(
				Font.TRUETYPE_FONT, SecuritySupport.getResourceAsStream("fonts\\cowboyjunkDEMO.ttf")
			);
*/

			indicators = Font.createFont(Font.TRUETYPE_FONT, getResource("fonts\\Saloon_Girl.ttf").openStream());

		}
		catch (FontFormatException | IOException e) {

			e.printStackTrace();
		}
	}
}