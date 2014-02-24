//public class Othello extends Game {
public class Othello {

    private int counter, scoreWhite, scoreBlack;
    private boolean playerTurn;
    private final int boardLength = 8;
    private int[] flipdata;
    private char[][] AvailableMov;
	private HumanPlayer P1;
	private HumanPlayer P2;
	private GamePiece playerColor;
	
	public Othello(HumanPlayer P1, HumanPlayer P2){
		this.P1 = P1;
		this.P2 = P2;
		System.out.println("Othello Game created");
		if(P1.GetPlayerTurn()){
			if (P1.GetPiece().getColour().equals("black")) {
				System.out.println("Player 1(BLACK) Turn");
			} else {
				System.out.println("Player 1(WHITE) Turn");
			}
		} else if(P2.GetPlayerTurn()){
			if (P2.GetPiece().getColour().equals("black")) {
				System.out.println("Player 2(BLACK) Turn");
			} else {
				System.out.println("Player 2(WHITE) Turn");
			}
		}
	}
	
	public int GetBoardSizeY(){
		return boardLength;
	}
	
	public int GetBoardSizeX(){
		return boardLength;
	}

    public boolean GetPlayerTurn() {
        return playerTurn = P1.GetPlayerTurn();
    }

    public void SetPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    /*public String GetFirstPlayer() {
     if (playerTurn == true){
     return selection.getplayerName();
     } else {
     return selection.getCPUName();
     }
     }*/
    //need calcWhiteScore and calcBlackScore from OthelloFB?
    /*private int GetScoreWhite() {
        scoreWhite = initialScore;
        for (int x = 0; x < boardLength; x++) {
            for (int y = 0; y < boardLength; y++) {
                if (gameBoard[y][x] == white) {
                    scoreWhite++;
                }
            }
        }
        return scoreWhite;
    }

    private int GetScoreBlack() {
        scoreBlack = initialScore;
        for (int x = 0; x < boardLength; x++) {
            for (int y = 0; y < boardLength; y++) {
                if (gameBoard[y][x] == black) {
                    scoreBlack++;
                }
            }
        }
        return scoreBlack;
    }*/

    public char[][] AvailableMove(GamePiece[][] gameBoard, boolean playerTurn) {   // check available move and return the char array.     
        // 'O' means available move.
        AvailableMov = new char[boardLength][boardLength];
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (validMove(i, j, gameBoard, playerTurn)) {
                    AvailableMov[i][j] = 'O';   //Location of Available Move 
                } else {
                    AvailableMov[i][j] = 'X';
                }
            }
        }
        CheckPassTurn(gameBoard);
        return AvailableMov;

    }

    private void CheckPassTurn(GamePiece[][] gameBoard) {     // check the player if he has no any available move , pass the turn to opponent.
        boolean passTurn = true;
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (AvailableMov[i][j] == 'O') {    // Check the AvailableMov in array
                    passTurn = false;              // if there is AvailableMov , then no need to pass the turn to opponent
                }
            }
        }
        if (passTurn == true) {                    // if there is no any available Move , then pass the turn to opponent
            System.out.println("Pass turn");
            if (P1.GetPlayerTurn()) {
                P1.SetPlayerTurn(false);
                P2.SetPlayerTurn(true);
            } else {
                P2.SetPlayerTurn(false);
                P1.SetPlayerTurn(true);
            }
        }

        for (int i = 0; i < boardLength; i++) {         // After pass the turn to opponent , check the available move again 
            for (int j = 0; j < boardLength; j++) {
                if (validMove(i, j, gameBoard, playerTurn)) {
                    AvailableMov[i][j] = 'O';
                } else {
                    AvailableMov[i][j] = 'X';
                }

            }
        }
    }

    /*public void game(GamePiece[][] gameBoard, boolean playerTurn) {   //??

    }*/

    public GamePiece[][] Move(int y, int x, GamePiece[][] gameBoard, boolean playerTurn) {   //move action 
        if (validMove(y, x, gameBoard, playerTurn) == true) {        // check whether the move is valid or not.
            if (P1.GetPlayerTurn() == true) {            // check the player turn 
                do {
                    gameBoard = Flip(flipdata, gameBoard);             //do the flip action here 
                } while (validMove(y, x, gameBoard, playerTurn));     // while it is valid move 
                gameBoard[y][x] = P1.GetPiece();         // add the piece into gameBoard
                P1.SetPlayerTurn(false);
                P2.SetPlayerTurn(true);
                //System.out.println("Black score:" + GetScoreBlack());
                //System.out.println("White score:" + GetScoreWhite());
				if (P2.GetPiece().getColour().equals("black")) {
					System.out.println("Player 2(BLACK) Turn");
				} else {
					System.out.println("Player 2(WHITE) Turn");
				}
                return gameBoard;
            } else {
                do {
                    gameBoard = Flip(flipdata, gameBoard);
                } while (validMove(y, x, gameBoard, playerTurn));
                gameBoard[y][x] = P2.GetPiece();
                P2.SetPlayerTurn(false);
                P1.SetPlayerTurn(true);
                //System.out.println("Black score:" + GetScoreBlack());
                //System.out.println("White score:" + GetScoreWhite());
				if (P1.GetPiece().getColour().equals("black")) {
					System.out.println("Player 1(BLACK) Turn");
				} else {
					System.out.println("Player 1(WHITE) Turn");
				}
                return gameBoard;
            }

        }

		System.out.println("Non-valid move");
        return gameBoard;
    }

    private boolean validMove(int y, int x, GamePiece[][] gameBoard, boolean playerturn) { // check valid move here (OTHELLO CORE)

        if (gameBoard[y][x] == null) {
            int searchX, searchY;
            GamePiece searchValue, playerColor;

            if (P1.GetPlayerTurn() == true) {
                playerColor = P1.GetPiece();
            } else {
                playerColor = P2.GetPiece();
            }
            counter = 1;

            // Search each direction (total : 8 direction)
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    boolean found = false;
                    searchY = y + i;
                    searchX = x + j;
                    if ((searchX >= boardLength || searchX < 0) || (searchY >= boardLength || searchY < 0)) {
                        //System.out.println("Over bound! Y:" + searchY + " X: " + searchX + " i:" + i + " j: " + j);  
                        //Debug message 
                        continue;

                    } else {
                        searchValue = gameBoard[searchY][searchX];
                    }
                    // skip the search if i and j is 0.
                    // skip the search if one of the direction is empty
                    // skip the search if one of the direction is same color piece
                    if ((i == 0 && j == 0) || searchValue == null || searchValue == playerColor) {
                        continue;
                    }
                    counter = 1;
                    //Searching along the direction
                    while (!found) {
                        //System.out.println("Looping..");
                        //Debug message
                        searchX += j;
                        searchY += i;

                        //prevent out of bound, if over 8, exit the while loop and stop searching this direction
                        if ((searchX >= boardLength || searchX < 0) || (searchY >= boardLength || searchY < 0)) {
                            found = true;
                        } else {
                            searchValue = gameBoard[searchY][searchX];
                        }
						//System.out.println(playerColor.getColour());
                        // if find the same color is along to direction 
                        if (searchValue == playerColor) {
                            found = true;
                            flipdata = new int[]{searchY, searchX, i, j, counter};   // store the piece and ready to flip 
							this.playerColor = playerColor;
                            //System.out.println("found : true, Y:" + searchY + ", X:" + searchX + ", newp value:" + searchValue);
                            //Debug message
                            return true;
                        } //If end of the direction is empty , then stop search this direction.
                        else if (searchValue == null) {
                            found = true;
                            //System.out.println("empty : true, Y:" + searchY + ", X:" + searchX);
                            //Debug message
                        }
                        counter++;
                    }
                }

            }

            return false;
        }
        return false;

    }

    private GamePiece[][] Flip(int[] flipdata, GamePiece[][] gameBoard) {
        //System.out.println("FLIP "+flipdata[4]+" PIECE(S)");
        for (int a = 0; a < flipdata[4]; a++) {
            flipdata[1] -= flipdata[3];
            flipdata[0] -= flipdata[2];
            gameBoard[flipdata[0]][flipdata[1]] = playerColor;
        }
        return gameBoard;
    }
	
	public void SetScoreWhite(int scoreWhite){
		this.scoreWhite = scoreWhite;
	}
	
	public void SetScoreBlack(int scoreBlack){
		this.scoreBlack = scoreBlack;
	}

    public boolean winningCondition() {
        for (int x = 0; x < boardLength; x++) {
            for (int y = 0; y < boardLength; y++) {
                if (AvailableMov[y][x] == 'O') {
                    //  return "gameon";
                    return false;
                }
            }
        }
		        if (scoreBlack == scoreWhite) {
		            System.out.println("draw");
		        } else if ((scoreWhite > scoreBlack && P1.GetPiece().getColour().equals("white"))|| (scoreBlack > scoreWhite && P1.GetPiece().getColour().equals("black"))){
		               System.out.println("Player 1 wins");
		        } else {
		               System.out.println("Player 2 wins");
		        }
        return true;

    }

}
