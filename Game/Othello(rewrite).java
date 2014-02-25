package boardGame;

import piece.*;

public class Othello extends BoardGame {

	final int boardHigh = 8, boardWide = 8;
	private int counter, scoreWhite, scoreBlack;
	private int[] flipdata;
	private char[][] availableMov;

	public Othello(int w, int h) {
		super(w, h);
	}
	
	public boolean setPiece(int x, int y, String col){
		board[y][x] = new OthelloPiece(col);
		return true;
	}

	public boolean Move(int y, int x, String col) { // move action
		if (validMove(y, x, col) == true) { // check whether the move is valid
											// or not.
			do {
				Flip(flipdata, col); // do the flip action here
			} while (validMove(y, x, col)); // while it is valid move
			board[y][x] = new OthelloPiece(col); // add the piece into gameBoard
			return true;
		} else
			return false;
	}

	private boolean validMove(int y, int x, String col) { // check valid move
															// here (OTHELLO
															// CORE)

		if (board[y][x] == null) {
			int searchX, searchY;
			GamePiece searchValue;

			counter = 1;

			// Search each direction (total : 8 direction)
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					boolean found = false;
					searchY = y + i;
					searchX = x + j;
					if ((searchX >= boardWide || searchX < 0)
							|| (searchY >= boardHigh || searchY < 0)) {
						// System.out.println("Over bound! Y:" + searchY +
						// " X: " + searchX + " i:" + i + " j: " + j);
						// Debug message
						continue;

					} else {
						searchValue = board[searchY][searchX];
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
						// System.out.println("Looping..");
						// Debug message
						searchX += j;
						searchY += i;

						// prevent out of bound, if over 8, exit the while loop
						// and stop searching this direction
						if ((searchX >= boardWide || searchX < 0)
								|| (searchY >= boardHigh || searchY < 0)) {
							found = true;
						} else {
							searchValue = board[searchY][searchX];
						}
						// System.out.println(playerColor.getColour());
						// if find the same color is along to direction
						if (searchValue.getColour() == col) {
							found = true;
							flipdata = new int[] { searchY, searchX, i, j,
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
						else if (searchValue.getColour() == null) {
							found = true;
							// System.out.println("empty : true, Y:" + searchY +
							// ", X:" + searchX);
							// Debug message
						}
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
			board[flipdata[0]][flipdata[1]] = new OthelloPiece(col);
		}
	}

	public char[][] AvailableMove(String col) { // check available move and
												// return the char array.
		// 'O' means available move.
		availableMov = new char[boardHigh][boardWide];
		for (int i = 0; i < boardHigh; i++) {
			for (int j = 0; j < boardWide; j++) {
				if (validMove(i, j, col)) {
					availableMov[i][j] = 'O'; // Location of Available Move
				} else {
					availableMov[i][j] = 'X';
				}
			}
		}

		return availableMov;
	}

	private boolean CheckPassTurn() { // check the player if he has no any
										// available move , pass the turn to
										// opponent.
		boolean passTurn = true;
		for (int i = 0; i < boardHigh; i++) {
			for (int j = 0; j < boardWide; j++) {
				if (availableMov[i][j] == 'O') { // Check the AvailableMov in
													// array
					passTurn = false; // if there is AvailableMov , then no need
										// to pass the turn to opponent
				}
			}
		}
		return passTurn;
	}

	// public boolean winningCondition() {
	// for (int x = 0; x < boardWide; x++) {
	// for (int y = 0; y < boardHigh; y++) {
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
