package gui.infoPanel;

import javax.swing.*;
import gui.TemporalParent;

import java.awt.*;

public class GameHeadline extends TemporalParent {

	JLabel
		panelHeadline = new JLabel();

	public GameHeadline() {

		super();

		setLayout(null);
		setBounds(headlinePanelBounds[0], headlinePanelBounds[1], headlinePanelBounds[2], headlinePanelBounds[3]);

		panelHeadline.setBounds(0, 0, headlinePanelBounds[2], headlinePanelBounds[2] * 226 / 910);

		Font
			bannerFont = headlines.deriveFont((float) (headlinePanelBounds[3] >> 1));

		panelHeadline.setFont(bannerFont);
		panelHeadline.setHorizontalTextPosition(SwingConstants.CENTER);
		panelHeadline.setText("MEMORY");

		add(panelHeadline);
	}
}
