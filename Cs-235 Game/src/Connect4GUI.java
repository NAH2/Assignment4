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
		
		for (int y = 0; y < getBoard().getHeight(); ++y) {
			for (int x = 0; x < getBoard().getWidth(); ++x) {
				m_panels[x][y].removeAll();
				m_panels[x][y].add(new JLabel((m_empty)));
				m_panels[x][y].setBackground(Color.BLUE);
			}
		}
		return true;
	}

	public boolean setImages() {
		try {
			m_empty = new ImageIcon(getClass().getResource("empty.png"));
		} catch (Exception e) {
			System.out.println("Images not found");
		}

		return true;
	}

	private ImageIcon m_empty;
}
