/**
 * \file -ConnectFour.java 
 * \author -
 * \date -21th Feb 14
 * 
 * \see BoardGame.java
 * 
 * \brief ConnectFour is used to store the game rules and control the game board . 
 * extends BoardGame.java
 * 
 * This class extends from the BoardGame class. It will check the whether a column is full when 
 * the player place the pieces.
 */

package boardGame;

import piece.*;

public class ConnectFour extends BoardGame {
	private boolean m_draw;
	String yellow = "yellow";
	String red = "red";
	int searchY, searchX;
	int counter;
	String winningColour;

    /**
    * This is the constructor for the ConnectFour
    * It passes the height and the width to the BoardGame class for constructing the game board.
    *  
    */
	public ConnectFour() {
		super(10, 7);
	}

	 /**
     * Place the ConnectFour piece on the game board 
     * \param x   the x axis in the game board.
     * \param y   the y axis in the game board.
     * \param col the color of the game piece.
     * \return boolean  return true if the action complete.
     */
	public boolean SetPiece(int x, int y, String col) {
		board[x][y] = new ConnectFourPiece(col);
		return true;
	}

	/**
     *  If the move is valid, place the piece on the game board and check the winning condition.
     * \param x   the x axis in the game board.
     * \param y   the y axis in the game board.
     * \param col the color of the game piece.
     * \return boolean return true if the move is valid and the piece has been placed on the game board, false if the column is full.
     */
	public boolean Move(int x, int y, String col) {
		int index = 0;
		if (board[x][0] == null) {
			for (int h = 0; h < GetHeight() - 1; ++h) {
				if (board[x][h + 1] == null) {
					index = h + 1;
				} else if (board[x][h] == null) {
					index = h;
				}
			}
			SetPiece(x, index, col);
			checkWin(col);

			return true;
		} else {
			System.out.println("Space Occupied");
			return false;
		}

	}

	/**
     *   Check the winning condition by searching a sequence of pieces of the same color.
     * \param x   the x axis in the game board.
     * \param index   the lowest possible point in a column.
     * \param col the color of the game piece.
     * \return boolean return true if there is a sequence of four pieces of the same color, false while the game is on.
     */
	private boolean checkWin(String col) { 
		GamePiece searchPiece;
		for(int x=0;x<=GetWidth();x++){
			for(int index=0;index<=GetHeight();index++){		
		// Search each direction (total : 8 direction)
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				boolean found = true;
				// boolean found = false;
				searchY = index + i;
				searchX = x + j;
				counter = 0;
				while (found) {

					if ((searchX >= GetWidth() || searchX < 0)
							|| (searchY >= GetHeight() || searchY < 0)) {
						found = false;
					} else {
						searchPiece = board[searchX][searchY];

						// skip the search if i and j is 0.
						// skip the search if one of the direction is empty
						// skip the search if one of the direction is same color
						// piece
						if ((i == 0 && j == 0) || searchPiece == null
								|| searchPiece.getColour() != col) {
							found = false; 
						} else if (searchPiece.getColour() == col) {
							found = true; 
							counter++;
							if (counter == 4) {
							    winningColour = col;
								System.out.println(col+" wins");
								return true;
							}
							searchY = searchY + i;
							searchX = searchX + j;

						}
					}
					
				}
				
			}
		}
			}
		}
return false;
	}

    /**
     *  Call the setWinner method to set the winning color when the game ends.
     *  \return boolean return true if one of the players wins the game, false if the game is on.
     */ 
    @Override
    public boolean WinningCondition() {
        if (counter >= 4) {
            SetWinner();
            return true;
        }
        m_draw = true;
        for (int x=0; x<GetWidth(); x++){
        	if(board[x][0] == null){
        		m_draw = false;
        		return m_draw;
        	} 
        }
        if (m_draw == true){
        	winningColour = "draw";
        	SetWinner();
        	return true;
        }
        return false;
    }

    /**
     *  Set the winning color for access from superclass.
     *  \return boolean return true if one of the players wins the game, false if the game is on.
     */ 
    @Override
    public boolean SetWinner() {
        SetWinningColour(winningColour);
        return false;
    }


}
