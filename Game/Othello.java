import java.awt.Color;

//public class Othello extends Game {
public class Othello{
    private int[][] gameBoard;
    private int scoreWhite, scoreBlack, boardLength = 8, initialScore = 0;
    private boolean playerTurn; //ture = black piece player, false = white piece player.
    private int empty = 0, black = 1, white = 2, counter;
	private int[] flipdata;
	private char[][] AvailableMov;
    //  GameBoard gb = new GameBoard(true);
    HumanPlayer P1 = new HumanPlayer("P1", false, black);
    HumanPlayer P2 = new HumanPlayer("P2", true, white);

    public void Othello(HumanPlayer P1, HumanPlayer P2) {
        if (P1.GetPlayerTurn() == true) {
            playerTurn = P1.GetPlayerTurn();
        } else {
            playerTurn = P2.GetPlayerTurn();
        }

    }
    //add playerTurn as parameter, maybe 2d array board as output(set Available markers as value 3 in the array)?
//
//    public boolean SetPlayer(boolean playerTurn) {
//        this.playerTurn = playerTurn;
//    }

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
    public int GetScoreWhite() {
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

    public int GetScoreBlack() {
        scoreBlack = initialScore;
        for (int x = 0; x < boardLength; x++) {
            for (int y = 0; y < boardLength; y++) {
                if (gameBoard[y][x] == black) {
                    scoreBlack++;
                }
            }
        }
        return scoreBlack;
    }

    public int[][] GetNewPiecePosition() {
        return null;
    }

    public char[][] AvailableMove(int[][] gameBoard, boolean playerTurn) {
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
        return AvailableMov;

    }

    public boolean ChangePieces(int[][] newPiecePosition) {
        return true;
    }

    public void game(int[][] gameBoard, boolean playerTurn) {

    }

    public int[][] Move(int y, int x, int[][] gameBoard, boolean playerTurn) {
        if (validMove(y, x, gameBoard, playerTurn)) {
            if (P1.GetPlayerTurn()) {
		do {
                    gameBoard = Flip(flipdata, gameBoard);
		} while (validMove(y, x, gameBoard, playerTurn));
		gameBoard[y][x] = P1.GetColor();
                P1.SetPlayerTurn(false);
                P2.SetPlayerTurn(true);
				this.gameBoard = gameBoard;//for other method in this class
				System.out.println("Black score:"+GetScoreBlack());
				System.out.println("White score:"+GetScoreWhite());
                return gameBoard;
            } else {
		do {
                    gameBoard = Flip(flipdata, gameBoard);
		} while(validMove(y, x, gameBoard, playerTurn));
		gameBoard[y][x] = P2.GetColor();
                P2.SetPlayerTurn(false);
                P1.SetPlayerTurn(true);
				this.gameBoard = gameBoard;
				System.out.println("Black score:"+GetScoreBlack());
				System.out.println("White score:"+GetScoreWhite());
                return gameBoard;
            }
		
        }	

	//if (GetPlayerTurn())System.out.println(P2.GetColor()+" turn"); else System.out.println(P1.GetColor()+" turn");
		this.gameBoard = gameBoard;
        return gameBoard;
    }

    public boolean validMove(int y, int x, int[][] gameBoard, boolean playerturn) {

        if (gameBoard[y][x] == 0) {
            int searchX, searchY;
            int searchValue, playerColor;

            if (P1.GetPlayerTurn() == true) {
                playerColor = P1.GetColor();
            } else {
                playerColor = P2.GetColor();
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
                        continue;

                    } else {
                        searchValue = gameBoard[searchY][searchX];
                    }
                    // skip the search if i and j is 0.
                    // skip the search if one of the direction is empty
                    // skip the search if one of the direction is same color piece
                    if ((i == 0 && j == 0) || searchValue == empty || searchValue == playerColor) {
                        continue;
                    }
					counter = 1;
                    //Searching along the direction
                    while (!found) {
                        //System.out.println("Looping..");
                        searchX += j;
                        searchY += i;

                        //prevent out of bound, if over 8, exit the while loop and stop searching this direction
                        if ((searchX >= boardLength || searchX < 0) || (searchY >= boardLength || searchY < 0)) {
                            found = true;
                        } else {
                            searchValue = gameBoard[searchY][searchX];
                        }

                        // if find the same color is along to direction 
                        if (searchValue == playerColor) {
                            found = true;
							flipdata = new int[] {searchY,searchX,i,j,counter,playerColor};
                            //System.out.println("found : true, Y:" + searchY + ", X:" + searchX + ", newp value:" + searchValue);
                            return true;
                        } //If end of the direction is empty , then stop search this direction.
                        else if (searchValue == empty) {
                            found = true;
                            //System.out.println("empty : true, Y:" + searchY + ", X:" + searchX);
                        }
			counter++;
                    }
                }

            }
            //System.out.println("false");
            return false;
        }
        //System.out.println("false");
        return false;

    }

	public int[][] Flip(int[] flipdata, int[][] gameBoard) {
		//System.out.println("FLIP "+flipdata[4]+" PIECE(S)");
			for(int a = 0; a<flipdata[4]; a++){
				flipdata[1] -= flipdata[3];
				flipdata[0] -= flipdata[2];
				gameBoard[flipdata[0]][flipdata[1]] = flipdata[5];
			}
		return gameBoard;
	}

    //change to string as output
    public boolean winningCondition() {
        for (int x = 0; x < boardLength; x++) {
            for (int y = 0; y < boardLength; y++) {
                if (AvailableMov[y][x] == 'O') {
                    //  return "gameon";
                    return false;
                }
            }
        }
		System.out.println("END");
        return true;
//        if (GetScoreBlack() == GetScoreWhite()) {
//            return "draw";
//        } else if (GetScoreWhite() > GetScoreBlack()) {
//            if ((Color.WHITE).equals(selection.getPlayerColor())) {
//                return selection.getplayerName() + " wins";
//            } else {
//                return selection.getCPUName() + " wins";
//            }
//        }
        // return "error";
    }

}
