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
		boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: SetHeight() BEGIN");
        }

        m_height= y;
		return true;
        
        if (test || m_test) {
            System.out.println("BoardGame :: SetHeight() END");
        }
	}

	 /**
     * Get the board height.
     * \return int  return the board height.
     */
	public int GetHeight() {
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: GetHeight() BEGIN");
        }

	    return m_height;
        
        if (test || m_test) {
            System.out.println("BoardGame :: GetHeight() END");
        }

	}

	 /**
     * Get the board height.
     * \param x and y, the position of the GamePiece.
     * \return GamePiece  return the GamePiece object of relative position.
     */
	public GamePiece GetPiece(int x, int y) {
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: GamePiece() BEGIN");
        }

	    if  (board[x][y] != null) {
	        return board[x][y];
	    } else {
	        return null;
	    }
        
        if (test || m_test) {
            System.out.println("BoardGame :: GamePiece() END");
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
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: GetTotalPieces() BEGIN");
        }

	    int count = 0;
	    for (int y = 0; y < m_height; ++y) {
	        for (int x = 0; x < m_width; ++x) {
	            if (board[x][y] != null) {
	                count++;
	            }
	        }
	    }
	    return count;
        
        if (test || m_test) {
            System.out.println("BoardGame :: GetTotalPieces() END");
        }

	}

		 /**
     * Set the board width.
     * \return boolean  return true if the action completes..
     */
	public boolean SetWidth(int x){
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: SetWidth() BEGIN");
        }

		m_width = x;
		return true;
        
        if (test || m_test) {
            System.out.println("BoardGame :: SetWidth() END");
        }

	}

	 /**
     * Get the board width.
     * \return int  return the board width.
     */
	public int GetWidth() {
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: GetWidth() BEGIN");
        }

	    return m_width;
        
        if (test || m_test) {
            System.out.println("BoardGame :: GetWidth() END");
        }

	}

		/**
     * Set the colour of pieces meet the winning condition to winningColour.
     * \param the winning colour.
     * \return boolean  return true if the action completes..
     */
	public boolean SetWinningColour(String winner) {
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: SetWinningColour() BEGIN");
        }

	    m_winningColour = winner;
	    return true;
        
        if (test || m_test) {
            System.out.println("BoardGame :: SetWinningColour() END");
        }

	}

		 /**
     * Get the winning colour.
     * \return String  return the colour.
     */
	public String GetWinningColour() {
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: GetWinningColour() BEGIN");
        }

	    return m_winningColour;
        
        if (test || m_test) {
            System.out.println("BoardGame :: GetWinningColour() END");
        }

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
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: BoardGame() BEGIN");
        }

	   SetWidth(x);
	   SetHeight(y);
	   board = new GamePiece[m_width][m_height];
        
        if (test || m_test) {
            System.out.println("BoardGame :: BoardGame() END");
        }

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
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("BoardGame :: toString() BEGIN");
        }

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
        
        if (test || m_test) {
            System.out.println("BoardGame :: toString() END");
        }

	}

	protected GamePiece[][] board;
    private int m_width;
    private int m_height;
    private String m_winningColour;
    private boolean m_test = false;
}
