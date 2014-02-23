<<<<<<< HEAD

import java.awt.Color;

public class Othello extends Game {

    private int[][] gameBoard, newPiecePosition;
    private int scoreWhite, scoreBlack, boardSizeX, boardSizeY, x, y, startingScore = 0;
    private boolean playerTurn; //ture = black piece player, false = white piece player.
    private int empty = 0, black = 1, white = 2, counter;
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
    //add playerTurn as parameter, maybe 2d array board as output(set available markers as value 3 in the array)?
//    private boolean SetAvailMarkers(int[][] move, boolean playerTurn) {
//        //
//        gameBoard.setUpdate(move);
//    }
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

    public String GetFirstPlayer() {
        return null;//?  May need getplayerName() from selection class
    }

    //change boardsize to boardsize x,y
    //need calcWhiteScore and calcBlackScore from OthelloFB?
//    public int GetScoreWhite() {
//        scoreWhite = startingScore;
//        for (x = 0; x < boardSizeX; x++) {
//            for (y = 0; y < boardSizeY; y++) {
//                if (gameBoard[x][y] == /*e.g. 1or2?*/) {
//                    scoreWhite++;
//                }
//            }
//        }
//        return scoreWhite;
//    }
//    public int GetScoreBlack() {
//        scoreBlack = startingScore;
//        for (x = 0; x < boardSizeX; x++) {
//            for (y = 0; y < boardSizeY; y++) {
//                if (gameBoard[x][y] == /*e.g. 1or2?*/) {
//                    scoreBlack++;
//                }
//            }
//        }
//        return scoreBlack;
//    }
    public int[][] GetNewPiecePosition() {
        return null;
    }

    @Override
    public char[][] availableMove(int[][] gameBoard, boolean playerTurn) {
        char[][] availableMov = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (validMove(i, j, gameBoard, playerTurn)) {
                    availableMov[i][j] = 'O';   //Location of available Move 
                } else {
                    availableMov[i][j] = 'X';
                }
            }
        }
        return availableMov;

    }

    public boolean ChangePieces(int[][] newPiecePosition) {
        return true;
    }

    public void game(int[][] gameBoard, boolean playerTurn) {

    }

    public int[][] Move(int y, int x, int[][] gameBoard, boolean playerTurn) {
        if (validMove(y, x, gameBoard, playerTurn)) {
            if (P1.GetPlayerTurn()) {
                gameBoard[y][x] = P1.GetColor();
                gameBoard = Flip(y, x, gameBoard, playerTurn);
                P1.SetPlayerTurn(false);
                P2.SetPlayerTurn(true);
                return gameBoard;
            } else {
                gameBoard[y][x] = P2.GetColor();
                gameBoard = Flip(y, x, gameBoard, playerTurn);
                P2.SetPlayerTurn(false);
                P1.SetPlayerTurn(true);
                return gameBoard;
            }

        }
        return gameBoard;
    }

    @Override
    public boolean validMove(int y, int x, int[][] gameBoard, boolean playerturn) {

        if (gameBoard[y][x] == 0) {
            int searchX, searchY;
            int searchValue, playerColor;

            if (P1.GetPlayerTurn() == true) {
                playerColor = P1.GetColor();
            } else {
                playerColor = P2.GetColor();
            }

            // Search each direction (total : 8 direction)
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    boolean found = false;
                    searchY = y + i;
                    searchX = x + j;
                    if ((searchX >= 8 || searchX < 0) || (searchY >= 8 || searchY < 0)) {
                        System.out.println("Over bound! Y:" + searchY + " X: " + searchX + " i:" + i + " j: " + j);
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

                    //Searching along the direction
                    while (!found) {
                        System.out.println("Looping..");
                        searchX += j;
                        searchY += i;

                        //prevent out of bound, if over 8, exit the while loop and stop searching this direction
                        if ((searchX >= 8 || searchX < 0) || (searchY >= 8 || searchY < 0)) {
                            found = true;
                        } else {
                            searchValue = gameBoard[searchY][searchX];
                        }

                        // if find the same color is along to direction 
                        if (searchValue == playerColor) {
                            found = true;
                            System.out.println("found : true, Y:" + searchY + ", X:" + searchX + ", newp value:" + searchValue);
                            return true;
                        } //If end of the direction is empty , then stop search this direction.
                        else if (searchValue == empty) {
                            found = true;
                            System.out.println("empty : true, Y:" + searchY + ", X:" + searchX);
                        }
                    }
                }

            }
            System.out.println("false");
            return false;
        }
        System.out.println("false");
        return false;

    }

    public int[][] Flip(int y, int x, int[][] gameBoard, boolean playerTurn) {

        int searchX, searchY;
        int searchValue, playerColor;

         if (P1.GetPlayerTurn() == true) {
                playerColor = P1.GetColor();
            } else {
                playerColor = P2.GetColor();
            }
        counter = 1;
        // Search each direction (8 direction)
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                boolean found = false;
                searchY = y + i;
                searchX = x + j;
                if ((searchX >= 8 || searchX < 0) || (searchY >= 8 || searchY < 0)) {
                    System.out.println("Over bound! Y:" + searchY + " X: " + searchX + " i:" + i + " j: " + j);
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
               
                //Search along the direction
                while (!found) {
                    System.out.println("Looping..");
                    searchX += j;
                    searchY += i;
                    //prevent out of bound, if over 8, exit the while loop and stop search this direction
                    if ((searchX >= 8 || searchX < 0) || (searchY >= 8 || searchY < 0)) {
                        found = true;
                    } else {
                        searchValue = gameBoard[searchY][searchX];
                    }
                    // if found the same color is along to direction 
                    if (searchValue == playerColor) {
                        found = true;
                        System.out.println("found : true, Y:" + searchY + ", X:" + searchX + ", newp value:" + searchValue);
                        System.out.println("FLIP " + counter + " PIECE(S)");
                        for (int a = 0; a < counter; a++) {
                            searchX -= j;
                            searchY -= i;
                            gameBoard[searchY][searchX] = playerColor;
                        }
                        return gameBoard;
                    } //If end of the direction is empty , then stop search this direction.
                    else if (searchValue == empty) {
                        found = true;
                        //return gameBoard;
                        //System.out.println("empty : true, Y:" + searchY + ", X:" + searchX);
                    }
                    counter++;
                }
            }

        }
        //System.out.println("false");
        //return gameBoard;
        return gameBoard;

    }

    //change to string as output
    public boolean winningCondition(int[][] currentGameBoard) {
        for (x = 0; x < boardSizeX; x++) {
            for (y = 0; y < boardSizeY; y++) {
                if (gameBoard[x][y] != 1 && gameBoard[x][y] != 2) {
                    //  return "gameon";
                    return true;
                }
            }
        }
        return false;
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
=======
import java.awt.Color;
//public class Othello extends Game {
	public class Othello {

	//private int[][] gameBoard, newPiecePosition;
	private int scoreWhite, scoreBlack, boardLength = 8, initialScore = 0;
	private boolean playerTurn;
	private int empty = 0,black = 1, white = 2, counter;
	private int[] flipdata;
	
	public boolean SetPlayer(boolean playerTurn) {
		this.playerTurn = playerTurn;
		return true;
	}
	
	/*public String GetFirstPlayer() {
		if (playerTurn == true){
			return selection.getplayerName();
		} else {
			return selection.getCPUName();
		}
	}*/
	
	//need calcWhiteScore and calcBlackScore from OthelloFB?
	/*public int GetScoreWhite() {
		scoreWhite = initialScore;
		for(x=0;x<boardLength;x++){	
			for(y=0;y<boardLength;y++){
				if(gameBoard[x][y] == 2){
					scoreWhite++;
				}
			}
		}
		return scoreWhite;
	}
	
	public int GetScoreBlack() {
		scoreBlack = initialScore;
		for(x=0;x<boardLength;x++){	
			for(y=0;y<boardLength;y++){
				if(gameBoard[x][y] == 1){
					scoreBlack++;
				}
			}
		}
		return scoreBlack;
	}*/
	
	//public int[][] GetNewPiecePosition() {
	//}
	
	public char[][] AvailableMove(int[][] gameBoard, boolean playerTurn) {
	        char[][] availableMov = new char[boardLength][boardLength];
	        for (int i = 0; i < boardLength; i++) {
	            for (int j = 0; j < boardLength; j++) {
	                if( ValidMove(i,j,gameBoard,playerTurn)){
	                    availableMov[i][j] = 'O';   //Location of available Move 
	                }
	                else 
	                    availableMov[i][j] = 'X';
	            }
	        }
	        return availableMov;
	        
	}
	
	/*public boolean ChangePieces(int[][] newPiecePosition) {
	}
	
	public boolean Game(int boardLength, boolean playerTurn) {
	}*/
	
	public int[][] Move(int y, int x, int[][] gameBoard, boolean playerTurn) {  
		//true = black piece player, false = white piece player.
	        if (ValidMove(y, x, gameBoard, playerTurn)) {
	            if (playerTurn == true) {
	                gameBoard[y][x] = black;
					gameBoard = Flip(flipdata, gameBoard);
	                return gameBoard;
	            } else {
	                gameBoard[y][x] = white;
					gameBoard = Flip(flipdata, gameBoard);
	                return gameBoard;
	            }
	        } 
	        return gameBoard;
	    }
	
	public boolean ValidMove(int y, int x, int[][] gameBoard, boolean playerTurn) {

		        if (gameBoard[y][x] == 0) {
		            int searchX, searchY;
		            int searchValue, playerColor;

		            if (playerTurn == true) {
		                playerColor = black;
		            } else {
		                playerColor = white;
		            }
			    counter = 1;

		            // Search each direction (8 direction)
		            for (int i = -1; i <= 1; i++) {
		                for (int j = -1; j <= 1; j++) {
		                    boolean found = false;
		                    searchY = y + i;
		                    searchX = x + j;
		                    if ((searchX >= boardLength || searchX < 0) || (searchY >= boardLength || searchY < 0)) {
		                            //System.out.println("Over bound! Y:" + searchY +" X: " +searchX + " i:" + i +" j: " + j);
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
							
							counter = 0;
		                    //Search along the direction
		                    while (!found) {
		                        //System.out.println("Looping..");
		                        searchX += j;
		                        searchY += i;
		                        //counter = 1;
		                        //prevent out of bound, if over 8, exit the while loop and stop search this direction
		                        if ((searchX >= boardLength || searchX < 0) || (searchY >= boardLength || searchY < 0)) {
		                            found = true;
		                        } else {
		                            searchValue = gameBoard[searchY][searchX];
		                        }

		                        // if found the same color is along to direction 
		                        if (searchValue == playerColor) {
		                            found = true;
						        flipdata = new int[] {searchY,searchX,i,j,counter,playerColor};
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
			System.out.println("FLIP "+flipdata[4]+" PIECE(S)");
				for(int a = 0; a<flipdata[4]; a++){
					flipdata[1] -= flipdata[3];
					flipdata[0] -= flipdata[2];
					gameBoard[flipdata[0]][flipdata[1]] = flipdata[5];
				}
			return gameBoard;
		}
		
	//change to string as output
	/*public String WinningCondition(int[][] currentGameBoard) {
		for(x=0;x<boardLength;x++){	
			for(y=0;y<boardLength;y++){
				if(gameBoard[x][y] != 1 && gameBoard[x][y] != 2){
					return "gameon";
				}
			}
		}
		
		if (GetScoreBlack()==GetScoreWhite()){
			return "draw";
		} else if (GetScoreWhite()>GetScoreBlack()) {
			if((Color.WHITE).equals(selection.getPlayerColor())){
				return selection.getplayerName()+" wins";
			} else {
				return selection.getCPUName()+" wins";
			}
		}
		return "error";
	}*/
	
}
>>>>>>> d72ce5f121019a3762ba25f812f7905978ce4010
