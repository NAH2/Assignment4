import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import boardGame.*;
import javax.swing.*;

import piece.ConnectFourPiece;

public class Connect4GUI extends GUI {

	public Connect4GUI(BoardGame b, GameController g) {
		super(b, g);
		setImages();
		setConnectFourInfo();
	}

	public boolean setConnectFourInfo(){
		playerTurnIcon.setIcon(new ConnectFourPiece(m_game.getCurrent()).getIcon());
		playerTurnIcon.setVisible(true);
		playerTurnLabel.setText("'s TURN");
		playerTurnLabel.setFont(f);
		playerTurnLabel.setVisible(true);
		return true;
	}
	
	public boolean SetPanelColour() {
		
		for (int y = 0; y < getBoard().GetHeight(); ++y) {
			for (int x = 0; x < getBoard().GetWidth(); ++x) {
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
