/**
 * \file -BoardGame.java 
 * \author -
 * \date -20nd Feb 14
 * 
 * \brief BoardGame is an abstract class 
 * \see ConnectFour.java
 * \see Othello.java
 * 
 * BoardGame is the superclass of both Othello and Connect Four class
 */
 package boardGame;

import piece.*;

public abstract class BoardGame {
	
		 /**
     * Set the board height.
     * \return boolean  return true if the action completes..
     */
	public boolean SetHeight(int y){
		m_height= y;
		return true;
	}

	 /**
     * Get the board height.
     * \return int  return the board height.
     */
	public int GetHeight() {
	    return m_height;
	}

	 /**
     * Get the board height.
     * \param x and y, the position of the GamePiece.
     * \return GamePiece  return the GamePiece object of relative position.
     */
	public GamePiece GetPiece(int x, int y) {
	    if  (board[x][y] != null) {
	        return board[x][y];
	    } else {
	        return null;
	    }
	}

		 /**
     * Abstract method
     * \param x and y, the position of the GamePiece, the colour of the piece.
     * \return boolean
     */
	public abstract boolean SetPiece(int x, int y, String col);

	 /**
     * Get the total number of pieces on the game board.
     * \return int  return the number of pieces on the game board.
     */
	public int GetTotalPieces() {
	    int count = 0;
	    for (int y = 0; y < m_height; ++y) {
	        for (int x = 0; x < m_width; ++x) {
	            if (board[x][y] != null) {
	                count++;
	            }
	        }
	    }
	    return count;
	}

		 /**
     * Set the board width.
     * \return boolean  return true if the action completes..
     */
	public boolean SetWidth(int x){
		m_width = x;
		return true;
	}

	 /**
     * Get the board width.
     * \return int  return the board width.
     */
	public int GetWidth() {
	    return m_width;
	}

		/**
     * Set the colour of pieces meet the winning condition to winningColour.
     * \param the winning colour.
     * \return boolean  return true if the action completes..
     */
	public boolean SetWinningColour(String winner) {
	    m_winningColour = winner;
	    return true;
	}

		 /**
     * Get the winning colour.
     * \return String  return the colour.
     */
	public String GetWinningColour() {
	    return m_winningColour;
	}
		 
		 /**
     * Abstract method.
     * \return boolean
     */
	public abstract boolean SetWinner();

		 /**
     * Constructor of BoardGame, create a game board that stores the game pieces.
     * \param width and the height of the game board.
     */
	public BoardGame(int x, int y) {
	   SetWidth(x);
	   SetHeight(y);
	   board = new GamePiece[m_width][m_height];
	}
	
			 /**
     * Abstract method.
     * \param X,y position and the colour of the piece.
     * \return boolean
     */
	public abstract boolean Move(int x, int y, String col);

		 /**
     * Abstract method.
     * \return boolean
     */
	public abstract boolean WinningCondition();

			 /**
     * This method is used for testing
     * \return String  gameBoard consists of texts.
     */
	@Override
	public String toString() {
	    String boardStateString = "";
	    String newline = System.getProperty("line.separator");
	    
	    for (int y = 0; y < m_height; ++y) {
	        for (int x = 0; x < m_width; ++x) {
	            if (board[x][y] != null) {
	                boardStateString += "[" + board[x][y].GetColour() + "] ";
	            } else {
	                boardStateString += "[" + null + "] "; 
	            }
	            
	            if (x == m_width-1) {
	                boardStateString += newline;
	            }
	        }
	    }
	    return boardStateString;
	}

	protected GamePiece[][] board;
    private int m_width;
    private int m_height;
    private String m_winningColour;
}
