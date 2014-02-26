package boardGame;

import piece.*;

public class Othello extends BoardGame {
/* no need for these variables, you can call getHeight() and getWidth() to retrieve this data from the super class, 
 * i used find and replace to change them for you
 */
	//final int boardWide = 8, boardHigh = 8;
	private int counter, scoreWhite, scoreBlack;
	private int[] flipdata;
	private char[][] availableMov;

	public Othello() {
		super(8, 8);
		initialGame();
	}
	
	private void initialGame(){
	  this.setPiece(3,3,"black");
	  this.setPiece(4,4,"black");
	  this.setPiece(4,3,"white");
	  this.setPiece(3,4,"white");
	}
	

	
	/* this method gets called by the event handler, so handle the move from here, maybe call Move(x, y, col) from here? */
	public boolean setPiece(int x, int y, String col){
	    /* i switched x and y here, you had board[y][x]. it should be board[x][y] every time
	     * or the board goes on its side. i havn't switched any others, just did this one to show you
	     */
		board[x][y] = new OthelloPiece(col);
		return true;
	}
	
	public boolean move(int x, int y, String col) { // move action
		if (validMove(x, y, col) == true) { // check whether the move is valid
			do {
				Flip(flipdata, col); // do the flip action here
			} while (validMove(x, y, col)); // while it is valid move
			//board[x][y] = new OthelloPiece(col); // add the piece into gameBoard
			setPiece(x,y,col);
			return true;
		} else
			return false;
	}

	private boolean validMove(int x, int y, String col) { // check valid move
															// here (OTHELLO
															// CORE)

		if (board[x][y] == null) {
			int searchX, searchY;
			GamePiece searchValue;

			counter = 1;

			// Search each direction (total : 8 direction)
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					boolean found = false;
					searchY = y + i;
					searchX = x + j;
					if ((searchX >= getWidth() || searchX < 0)
							|| (searchY >= getHeight() || searchY < 0)) {
						 System.out.println("Over bound! Y:" + searchY +
						" X: " + searchX + " i:" + i + " j: " + j);
						// Debug message
						continue;

					} else {
						searchValue = board[searchX][searchY];
					}
					// skip the search if i and j is 0.
					// skip the search if one of the direction is empty
					// skip the search if one of the direction is same color
					// piece
					if ((i == 0 && j == 0) || searchValue == null
							|| searchValue.getColour() == col) {
						continue;
					}
					counter = 1;
					// Searching along the direction
					while (!found) {
						 System.out.println("Looping..");
						// Debug message
						searchX += j;
						searchY += i;

						// prevent out of bound, if over 8, exit the while loop
						// and stop searching this direction
						if ((searchX >= getWidth() || searchX < 0)
								|| (searchY >= getHeight() || searchY < 0)) {
							found = true;
						} else {
							searchValue = board[searchX][searchY];
							// System.out.println(searchValue.getColour());
						}
				
						
						// if find the same color is along to direction
						 if (searchValue == null) {
							found = true;
							// System.out.println("empty : true, Y:" + searchY +
							// ", X:" + searchX);
							// Debug message
						}
						 else if (searchValue.getColour() == col) {
							
							found = true;
							flipdata = new int[] { searchX, searchY, j, i,
									counter }; // store the piece and ready to
												// flip
							// this.playerColor = playerColor;

							// System.out.println("found : true, Y:" + searchY +
							// ", X:" + searchX + ", newp value:" +
							// searchValue);
							// Debug message
							return true;
						} // If end of the direction is empty , then stop search
							// this direction.
					
						counter++;
					}
				}

			}

			return false;
		}
		return false;

	}

	private void Flip(int[] flipdata, String col) {
		// System.out.println("FLIP "+flipdata[4]+" PIECE(S)");
		for (int a = 0; a < flipdata[4]; a++) {
			flipdata[1] -= flipdata[3];
			flipdata[0] -= flipdata[2];
			board[flipdata[0]][flipdata[1]].setColour(col); //= new OthelloPiece(col);
		}
	}

	public char[][] availableMove(String col) { // check available move and
												// return the char array.
		// 'O' means available move.
		availableMov = new char[getHeight()][getWidth()];
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				if (validMove(j, i, col)) {
					availableMov[j][i] = 'O'; // Location of Available Move
				} else {
					availableMov[j][i] = 'X';
				}
			}
		}

		return availableMov;
	}

	private boolean CheckPassTurn() { // check the player if he has no any
										// available move , pass the turn to
										// opponent.
		boolean passTurn = true;
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				if (availableMov[j][i] == 'O') { // Check the AvailableMov in
													// array
					passTurn = false; // if there is AvailableMov , then no need
										// to pass the turn to opponent
				}
			}
		}
		return passTurn;
	}

	// public boolean winningCondition() {
	// for (int x = 0; x < getWidth(); x++) {
	// for (int y = 0; y < getHeight(); y++) {
	// if (availableMov[y][x] == 'O') {
	// return false;
	// }
	// }
	// }
	// if (scoreBlack == scoreWhite) {
	// JOptionPane.showMessageDialog(null,"draw");
	// } else if ((scoreWhite > scoreBlack &&
	// P1.GetPiece().getColour().equals("white"))|| (scoreBlack > scoreWhite &&
	// P1.GetPiece().getColour().equals("black"))){
	// JOptionPane.showMessageDialog(null,P1.GetPlayerName()+" wins");
	// } else {
	// JOptionPane.showMessageDialog(null,P2.GetPlayerName()+" wins");
	// }
	// return true;
	//
	// }

}
