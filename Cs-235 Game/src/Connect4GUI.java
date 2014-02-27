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
		playerOneColor.setText(m_game.getPlayerName("red")+":");
		playerOneColor.setFont(f);
		playerOneColor.setVisible(true);
		ConnectFourPiece red = new ConnectFourPiece("red");
		playerOneIcon.setIcon(red.getIcon());
		playerOneIcon.setVisible(true);
		playerTwoColor.setText(m_game.getPlayerName("yellow")+":");
		playerTwoColor.setFont(f);
		playerTwoColor.setVisible(true);
		ConnectFourPiece yellow = new ConnectFourPiece("yellow");
		playerTwoIcon.setIcon(yellow.getIcon());
		playerTwoIcon.setVisible(true);
		playerTurnIcon.setIcon(new ConnectFourPiece(m_game.getCurrent()).getIcon());
		playerTurnIcon.setVisible(true);
		playerTurnLabel.setText("'s TURN");
		playerTurnLabel.setFont(f);
		playerTurnLabel.setVisible(true);
		m_frame.pack();
		return true;
	}
	
	public void drawPieces() {
		for (int y = 0; y < m_height; ++y) {
			for (int x = 0; x < m_width; ++x) {
				GamePiece p = m_board.getPiece(x, y);

				if (p != null) {
					m_labels[x][y].setIcon(p.getIcon());
					m_panels[x][y].removeAll();
				}
				m_panels[x][y].add(m_labels[x][y]);
			}
		}
		SwingUtilities.updateComponentTreeUI(m_frame);
		updatePlayerTurnIcon(new ConnectFourPiece(m_game.getCurrent()).getIcon());
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
