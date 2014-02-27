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
	/**
	 * This is the constructor for the ConnectFour It passes the height and the
	 * width to the BoardGame class for constructing the game board.
	 * 
	 */
	public ConnectFour() {
		super(INITIAL_X, INITIAL_Y);
	
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFour :: ConnectFour() BEGIN");
        }

		
        
        if (test || m_test) {
            System.out.println("ConnectFour :: ConnectFour() END");
        }
	}

	/**
	 * Place the ConnectFour piece on the game board \param x the x axis in the
	 * game board. \param y the y axis in the game board. \param col the color
	 * of the game piece. \return boolean return true if the action complete.
	 */
	public boolean SetPiece(int x, int y, String col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFour :: SetPiece() BEGIN");
        }
        if(x < GetWidth() && x >= 0 && y < GetHeight() && y >= 0) {
		board[x][y] = new ConnectFourPiece(col);
        	if (test || m_test) {
        		System.out.println("ConnectFour :: SetPiece() END");
        	} 
		return true;
        } else {
        	if (test || m_test) {
        		System.out.println("ConnectFour :: SetPiece() END");
        	}
		return false;
        }
	}

	/**
	 * Search a sequence of four pieces of the same color in all eight directions. 
	 *  \param x the x axis in the game board. 
	 *  \param index_y the lowest possible point in a column. 
	 *  \param col the color of the game piece.
	 * \return boolean return true if there is a sequence of four pieces of the same color, false while the game is on.
	 */
	private boolean allDirection(String col, int x, int index_y) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFour :: allDirection() BEGIN");
        }

		
				// Search each direction (total : 8 direction)
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if(singleDirection(col, x , index_y, i ,j)){
			        if (test || m_test) {
			            System.out.println("ConnectFour :: allDirection() END");
			        }
					return true;
				}
			}
		}
        if (test || m_test) {
            System.out.println("ConnectFour :: allDirection() END");
        }
		return false;
	}
	
	/**
	 * Search a sequence of pieces of the same color in a single direction. 
	 * \param x the x axis in the game board. 
	 * \param index_y the lowest possible point in a column. 
	 * \param col the color of the game piece.
	 * \param i the difference of width between the searching piece and the current piece
	 * \param j the difference of height between the searching piece and the current piece
	 * \return boolean return true if there is a sequence of four pieces of the same color, false while the game is on.
	 */
	private boolean singleDirection(String col, int x, int index_y, int i, int j){
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFour :: singleDirection() BEGIN");
        }

		GamePiece searchPiece;
		boolean found = true;
		// boolean found = false;
		m_searchY = index_y + i;
		m_searchX = x + j;
		m_counter = 0;
		while (found) {

			if ((m_searchX >= GetWidth() || m_searchX < 0)
					|| (m_searchY >= GetHeight() ||
					m_searchY < 0)) {
				found = false;
			} else {
				searchPiece = board[m_searchX][m_searchY];

				// skip the search if i and j is 0.
				// skip the search if one of the direction is
				// empty
				// skip the search if one of the direction is
				// same color
				// piece
				if ((i == 0 && j == 0) || searchPiece == null
						|| searchPiece.GetColour() != col) {
					found = false;
				} else if (searchPiece.GetColour() == col) {
					found = true;
					m_counter++;
					if (m_counter == 4) {
						m_winningColour = col;
						System.out.println(col + " wins");
				        if (test || m_test) {
				            System.out.println("ConnectFour :: singleDirection() END");
				        }
						return true;
					}
					m_searchY = m_searchY + i;
					m_searchX = m_searchX + j;

				}
			}

		}
        if (test || m_test) {
            System.out.println("ConnectFour :: singleDirection() END");
        }
		return false;
	}
	
	/**
	 * Check the winning condition by searching a sequence of pieces of the same
	 * color in the game board. 
	 * \param col the color of the game piece.
	 * \return boolean return true if there is a sequence of four pieces of the
	 * same color, false while the game is on.
	 */
	private boolean checkWin(String col){
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFour :: checkWin() BEGIN");
        }

		for (int x = 0; x <= GetWidth(); x++) {
			for (int index_y = 0; index_y <= GetHeight(); index_y++) {
				if(allDirection(col, x , index_y)){
			        if (test || m_test) {
			            System.out.println("ConnectFour :: singleDirection() END");
			        }
					return true;
				}
			}
		}
        if (test || m_test) {
            System.out.println("ConnectFour :: checkWin() END");
        }
		return false;
	}
	
	
		
	/**
	 * If the move is valid, place the piece on the game board and check the
	 * winning condition. \param x the x axis in the game board. \param y the y
	 * axis in the game board. \param col the color of the game piece. \return
	 * boolean return true if the move is valid and the piece has been placed on
	 * the game board, false if the column is full.
	 */
	public boolean Move(int x, int y, String col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFour :: Move() BEGIN");
        }

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
            if (test || m_test) {
                System.out.println("ConnectFour :: Move() END :: true");
            }
			return true;
		} else {
			System.out.println("Space Occupied");
            if (test || m_test) {
                System.out.println("ConnectFour :: Move() END :: false");
            }
			return false;
		}
	
	}

	/**
	 * Call the setWinner method to set the winning color when the game ends.
	 * \return boolean return true if one of the players wins the game, false if
	 * the game is on.
	 */
	@Override
	public boolean WinningCondition() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFour :: WinningCondition() BEGIN");
        }

		if (m_counter >= NUM_IN_ROW_WIN) {
			SetWinner();
	        if (test || m_test) {
	            System.out.println("ConnectFour :: singleDirection() END");
	        }
			return true;
		}
		m_draw = true;
		for (int x = 0; x < GetWidth(); x++) {
			if (board[x][0] == null) {
				m_draw = false;
		        if (test || m_test) {
		            System.out.println("ConnectFour :: singleDirection() END");
		        }
				return m_draw;
			}
		}
		if (m_draw == true) {
			m_winningColour = "draw";
			SetWinner();
	        if (test || m_test) {
	            System.out.println("ConnectFour :: singleDirection() END");
	        }
			return true;
		}
        if (test || m_test) {
            System.out.println("ConnectFour :: WinningCondition() END");
        }
		return false;
	}

	/**
	 * Set the winning color for access from superclass. \return boolean return
	 * true if one of the players wins the game, false if the game is on.
	 */
	@Override
	public boolean SetWinner() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFour :: SetWinner() BEGIN");
        }

		SetWinningColour(m_winningColour);
        if (test || m_test) {
            System.out.println("ConnectFour :: SetWinner() END");
        }
		return true;
	}
    
    /** main method for tests */
    public static void main(String[] args) {
        ConnectFour a = new ConnectFour();
        a.SetPiece(3,3,"red");
        a.allDirection("yellow",4,4);
        a.singleDirection("red",2,3,4,5);
        a.checkWin("yellow");
        a.Move(2,4,"red");
        a.WinningCondition();
        a.SetWinner();
    }
        
        

	private boolean m_draw;
	private int m_searchY, m_searchX;
	private int m_counter;
	private String m_winningColour;
	//The following two int's are static due to calling the BoardGame in method.
	private final static int INITIAL_X = 10;
	private final static int INITIAL_Y = 7;
	private final int NUM_IN_ROW_WIN = 4;
    private boolean m_test = false;
}
