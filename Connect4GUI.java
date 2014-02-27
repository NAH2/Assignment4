/**
 * \file -Connect4GUI.java 
 * \author -
 * \date -22nd Feb 14
 * 
 * \see GUI.java
 * 
 * \brief Connect4GUI is used to set up the background of the game board. 
 * extends GUI.java
 * 
 * This class extends from the GUI class, it sets up the background of the connect four game board.
 */
 
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import boardGame.*;
import javax.swing.*;

import piece.ConnectFourPiece;
import piece.GamePiece;
import piece.OthelloPiece;

public class Connect4GUI extends GUI {

	 /**
     * Set the the player names, player turn and the new game button to display on screen.
     * \return boolean  return true if the action complete.
     */
	public boolean SetConnectFourInfo(){
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
	
		 /**
     * Set the background colour of the connect four game board. 
     * \return boolean  return true if the action complete.
     */
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

	 /**
     * Set the image as the empty square in the game board. 
     * \return boolean  return true if the action complete.
     */
	public boolean setImages() {
		try {
			m_empty = new ImageIcon(getClass().getResource("empty.png"));
		} catch (Exception e) {
			System.out.println("Images not found");
		}

		return true;
	}
	
    /**
    * Constructor of Connect4GUI, calls the constructor of GUI for constructing the game board and sets the player information.
    * \param a BoardGame object which is in ConnectFour type, a GameController object.
    */
	public Connect4GUI(BoardGame b, GameController g) {
		super(b, g);
		setImages();
		SetConnectFourInfo();
	}

	private ImageIcon m_empty;
}
