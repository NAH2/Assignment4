import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import boardGame.*;
import javax.swing.*;

import piece.ConnectFourPiece;
import piece.GamePiece;
import piece.OthelloPiece;

public class Connect4GUI extends GUI {

	public Connect4GUI(BoardGame b, GameController g) {
		super(b, g);
		setImages();
		setConnectFourInfo();
	}

	public boolean setConnectFourInfo(){
		playerOneColor.setText(m_game.GetPlayerName("red")+":");
		playerOneColor.setFont(f);
		playerOneColor.setVisible(true);
		ConnectFourPiece red = new ConnectFourPiece("red");
		playerOneIcon.setIcon(red.GetIcon());
		playerOneIcon.setVisible(true);
		playerTwoColor.setText(m_game.GetPlayerName("yellow")+":");
		playerTwoColor.setFont(f);
		playerTwoColor.setVisible(true);
		ConnectFourPiece yellow = new ConnectFourPiece("yellow");
		playerTwoIcon.setIcon(yellow.GetIcon());
		playerTwoIcon.setVisible(true);
		playerTurnIcon.setIcon(new ConnectFourPiece(m_game.GetCurrent()).GetIcon());
		playerTurnIcon.setVisible(true);
		playerTurnLabel.setText(m_game.GetPlayerName(m_game.GetCurrent()) + "'s TURN");
		playerTurnLabel.setFont(f);
		playerTurnLabel.setVisible(true);
		m_frame.pack();
		return true;
	}
	
	public boolean SetPanelColour() {
		
		for (int y = 0; y < GetBoard().GetHeight(); ++y) {
			for (int x = 0; x < GetBoard().GetWidth(); ++x) {
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
