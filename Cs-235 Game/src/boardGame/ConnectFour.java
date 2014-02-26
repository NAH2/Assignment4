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
	String yellow = "yellow";
	String red = "red";
	int searchY, searchX;
	int counter;
	int w = 10;
	int h = 7;

        /**
        * This is the constructor for the Othello
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
	public boolean setPiece(int x, int y, String col) {
		board[x][y] = new ConnectFourPiece(col);
		return true;
	}

	/**
        *  If the move is valid, place the piece on the game board and check the winning condition.
        * \param x   the x axis in the game board.
        * \param y   the y axis in the game board.
        * \param col the color of the game piece.
        * \return boolean return true if the move is valid and the piece has been placed on the game board.
        */
	public boolean move(int x, int y, String col) {
		int index = 0;
		if (board[x][0] == null) {
			for (int h = 0; h < getHeight() - 1; ++h) {
				if (board[x][h + 1] == null) {
					index = h + 1;
				} else if (board[x][h] == null) {
					index = h;
				}
			}
			setPiece(x, index, col);
			winningCondition(x, index, col);

			return true;
		} else {
			System.out.println("Space Occupied");
			return false;
		}

	}

	private boolean winningCondition(int x, int index, String col) { 

		GamePiece searchPiece;

		// Search each direction (total : 8 direction)
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				boolean found = false;
				// boolean found = false;
				searchY = index + i;
				searchX = x + j;
				counter = 1;
				while (!found) {

					if ((searchX >= w || searchX < 0)
							|| (searchY >= h || searchY < 0)) {
						found = true;
					} else {
						searchPiece = board[searchX][searchY];

						// skip the search if i and j is 0.
						// skip the search if one of the direction is empty
						// skip the search if one of the direction is same color
						// piece
						if ((i == 0 && j == 0) || searchPiece == null
								|| searchPiece.getColour() != col) {
							found = true; 
						} else if (searchPiece.getColour() == col) {
							found = false; 
							counter++;
							if (counter == 4) {
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
		return false;

	}


}
