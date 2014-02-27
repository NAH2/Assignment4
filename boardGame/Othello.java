/**
 * \file -Othello.java 
 * \author -Chun Kit So 742666
 * \date -21th Feb 14
 * 
 * \see BoardGame.java
 * 
 * \brief Othello is used to store the game rules and control the game board . 
 * extends BoardGame.java
 * 
 * This class extends from the BoardGame class. It will check the valid move when the
 * player place the pieces and return the feedback.
 */

package boardGame;

import piece.*;

public class Othello extends BoardGame {
    
	private int counter, scoreWhite, scoreBlack, searchX, searchY, i_diff ,j_diff;
	private char[][] availableMov;

      /**
        * This is the constructor for the Othello.
        * It passes the height and the width to BoardGame class for constructing the game board.
        *  
        */
    public Othello() {
        super(8, 8);
        initialGame();
    }

      /**
        * Initialize the game. Four pieces are centered.        
        */
    private void initialGame() {
        this.SetPiece(3, 3, "black");
        this.SetPiece(4, 4, "black");
        this.SetPiece(4, 3, "white");
        this.SetPiece(3, 4, "white");
    }
    
      /**
        * Loop though the game board and count the current score.
        */
    private void countScore() {
        scoreBlack = 0;
        scoreWhite = 0;
        for (int i = 0; i < GetHeight(); i++) {
            for (int j = 0; j < GetWidth(); j++) {
                if (board[j][i] != null) {

                    if (board[j][i].GetColour() == "black") {
                        scoreBlack++;
                    } else if (board[j][i].GetColour() == "white")
                        scoreWhite++;
                }
            }
        }
        //System.out.println("Black Score:" + scoreBlack + " White Score:"
        //        + scoreWhite);
    }

      /**
        * Public method,It passes the score to GUI class.
        * \return scoreBlack the black player score.
        */
    
    public int GetBlackScore() {
        return scoreBlack;
    }


      /**
        * Public method,It passes the score to GUI class.
        * \return scoreWhite the white player score
        */
    
    public int GetWhiteScore() {
        return scoreWhite;
    }


       /**
        * Place the Othello piece on the game board 
        * \param x   the x axis in the game board.
        * \param y   the y axis in the game board.
        * \param col the color of the game piece.
        * \return boolean  return true if the action completes.
        */
    public boolean SetPiece(int x, int y, String col) {
    
        board[x][y] = new OthelloPiece(col);

        return true;
    }
    
      /**
        *  If the move is valid, place the piece on the game board and check the winning condition.
        * \param x   the x axis in the game board.
        * \param y   the y axis in the game board.
        * \param col the color of the game piece.
        * \return boolean return true if the move is valid and the piece has been placed on the game board.
        */

    public boolean Move(int x, int y, String col) { // move action
        if (validMove(x, y, col) == true) { // check whether the move is valid
            do {
                flip(col); // do the flip action here
            } while (validMove(x, y, col)); // while it is valid move
            SetPiece(x,y,col);  // add the piece into gameBoard
            countScore();
            WinningCondition();
            return true;
        } else
            return false;
    }

     /**
      *  Check whether the move is valid or not , It will search through 8 directions of the new piece.
      * \param x   the x axis in the game board.
      * \param y   the y axis in the game board.
      * \param col the color of the game piece.
      * \return boolean return true if the move is valid.
      */
    
    private boolean validMove(int x, int y, String col) { // check valid move
                                                            // here (OTHELLO
                                                            // CORE)
        if (board[x][y] == null) {
            GamePiece searchPiece;

            counter = 1;

            // Search each direction (total : 8 direction)
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    boolean found = false;
                    searchY = y + i;
                    searchX = x + j;
                    if ((searchX >= GetWidth() || searchX < 0)
                            || (searchY >= GetHeight() || searchY < 0)) {
                        // System.out.println("Over bound! Y:" + searchY +
                        // " X: "
                        // + searchX + " i:" + i + " j: " + j);
                        // Debug message
                        continue;

                    } else {
                        searchPiece = board[searchX][searchY];
                    }
                    // skip the search if i and j is 0.
                    // skip the search if one of the direction is empty
                    // skip the search if one of the direction is same color
                    // piece
                    if ((i == 0 && j == 0) || searchPiece == null
                            || searchPiece.GetColour() == col) {
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
                        if ((searchX >= GetWidth() || searchX < 0)
                                || (searchY >= GetHeight() || searchY < 0)) {
                            found = true;
                        } else {
                            searchPiece = board[searchX][searchY];
                            // System.out.println(searchValue.getColour());
                        }

                        // if find the same color is along to direction
                        if (searchPiece == null) {
                            found = true;
                            // System.out.println("empty : true, Y:" + searchY +
                            // ", X:" + searchX);
                            // Debug message
                        } else if (searchPiece.GetColour() == col) {

                            found = true;
							j_diff = j;
							i_diff = i;
                                                // flip

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
    
     /**
      *  Flip the piece if it is a valid move 
     * \param col the color of the game piece.
     */

	private void flip(String col) {
		for (int a = 0; a < counter; a++) {
			searchY -= i_diff;
			searchX -= j_diff;
			board[searchX][searchY].SetColour(col);
		}
	}

     /**
      *  Calculate all the available positions on the game board, then store them in a char array.
      *  \param col the color of the game piece.
      *  \return availableMov return the char array that store all the available moves.
      */
    
    public char[][] AvailableMove(String col) { // check available move and
                                                // return the char array.
        // 'O' means available move.
        availableMov = new char[GetHeight()][GetWidth()];
        for (int i = 0; i < GetHeight(); i++) {
            for (int j = 0; j < GetWidth(); j++) {
                if (validMove(j, i, col)) {
                    availableMov[j][i] = 'O'; // Location of Available Move
                } else {
                    availableMov[j][i] = 'X';
                }
            }
        }

        return availableMov;
    }

    
    /**
     *  check if the player do not have any available move , pass the turn to opponent.
     *  \return boolean return the char array that store all the available moves.
     */ 
    public boolean CheckPassTurn() {
        boolean passTurn = true;
        for (int i = 0; i < GetHeight(); i++) {
            for (int j = 0; j < GetWidth(); j++) {
                if (availableMov[j][i] == 'O') { // Check the AvailableMov in
                                                    // array
                    passTurn = false; // if there is AvailableMov , then no need
                                        // to pass the turn to opponent
                }
            }
        }
        return passTurn;
    }


    /**
     *  checking the winning condition, if the board has empty space or more than one black/white pieces on the board , the game keeps go on.
     *  \return boolean return true if the player win the game.
     */ 
    
    public boolean WinningCondition() {
        for (int x = 0; x < GetWidth(); x++) {
            for (int y = 0; y < GetHeight(); y++) {
                if (board[x][y] == null && scoreBlack != 0 && scoreWhite != 0) {
                    return false;
                }
            }
        }
        SetWinner();
        return true;

    }
    
    public boolean SetWinner() {
        if (scoreBlack == scoreWhite) {
            SetWinningColour("draw");
        } else if (scoreWhite > scoreBlack)
            SetWinningColour("white");
        else {
            SetWinningColour("black");
        }
        return true;
    }
}