import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import boardGame.*;
import javax.swing.*;

public class Connect4GUI extends GUI {

	public Connect4GUI(BoardGame b, GameController g) {
		super(b, g);
		setImages();
	}

	public boolean setPanelColour() {
		int top = 0;
		int bottom = getBoard().getHeight() - 1;
		int left = 0;
		int right = getBoard().getWidth() - 1;

		for (int y = 0; y < getBoard().getHeight(); ++y) {
			for (int x = 0; x < getBoard().getWidth(); ++x) {

				// set to images later
				panels[x][y].removeAll();
				panels[x][y].add(new JLabel((m_empty)));

				panels[x][y].setBackground(Color.BLUE);
			}
		}

		return true;
	}

	public boolean setImages() {
		try {
			m_empty = new ImageIcon(getClass().getResource("empty.png"));
			m_topLeft = Toolkit.getDefaultToolkit().createImage("topLeft.png");
			m_topRight = Toolkit.getDefaultToolkit()
					.createImage("topRight.png");
			m_bottomLeft = Toolkit.getDefaultToolkit().createImage(
					"bottomLeft.png");
			m_bottomRight = Toolkit.getDefaultToolkit().createImage(
					"bottomRight.png");
		} catch (Exception e) {
			System.out.println("Images not found");
		}

		return true;
	}

	ImageIcon m_empty;
	Image m_topLeft;
	Image m_topRight;
	Image m_bottomLeft;
	Image m_bottomRight;
}
