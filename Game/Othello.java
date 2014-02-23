import java.awt.Color;
//public class Othello extends Game {
	public class Othello {

	//private int[][] gameBoard, newPiecePosition;
	private int scoreWhite, scoreBlack, boardSize = 8, startingScore = 0;
	private boolean playerTurn;
	private int empty = 0,black = 1, white = 2, counter;
	
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
	
	//change boardsize to boardsize x,y
	//need calcWhiteScore and calcBlackScore from OthelloFB?
	/*public int GetScoreWhite() {
		scoreWhite = startingScore;
		for(x=0;x<boardSize;x++){	
			for(y=0;y<boardSize;y++){
				if(gameBoard[x][y] == 2){
					scoreWhite++;
				}
			}
		}
		return scoreWhite;
	}
	
	public int GetScoreBlack() {
		scoreBlack = startingScore;
		for(x=0;x<boardSize;x++){	
			for(y=0;y<boardSize;y++){
				if(gameBoard[x][y] == 1){
					scoreBlack++;
				}
			}
		}
		return scoreBlack;
	}*/
	
	//public int[][] GetNewPiecePosition() {
	//}
	
	public char[][] availableMove(int[][] gameBoard, boolean playerTurn) {
	        char[][] availableMov = new char[8][8];
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 8; j++) {
					//availableMov[i][j] = 'X';
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
	
	public boolean Game(int boardSize, boolean playerTurn) {
	}*/
	
	public int[][] Move(int y, int x, int[][] gameBoard, boolean playerTurn) {  
		//true = black piece player, false = white piece player.
	        if (ValidMove(y, x, gameBoard, playerTurn)) {
	            if (playerTurn == true) {
	                gameBoard[y][x] = black;
					gameBoard = Flip(y, x, gameBoard, playerTurn);
	                return gameBoard;
	            } else {
	                gameBoard[y][x] = white;
					gameBoard = Flip(y, x, gameBoard, playerTurn);
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

		            // Search each direction (8 direction)
		            for (int i = -1; i <= 1; i++) {
		                for (int j = -1; j <= 1; j++) {
		                    boolean found = false;
		                    searchY = y + i;
		                    searchX = x + j;
		                    if ((searchX >= 8 || searchX < 0) || (searchY >= 8 || searchY < 0)) {
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

		                    //Search along the direction
		                    while (!found) {
		                        //System.out.println("Looping..");
		                        searchX += j;
		                        searchY += i;
		                        //counter = 1;
		                        //prevent out of bound, if over 8, exit the while loop and stop search this direction
		                        if ((searchX >= 8 || searchX < 0) || (searchY >= 8 || searchY < 0)) {
		                            found = true;
		                        } else {
		                            searchValue = gameBoard[searchY][searchX];
		                        }

		                        // if found the same color is along to direction 
		                        if (searchValue == playerColor) {
		                            found = true;
		                            //System.out.println("found : true, Y:" + searchY + ", X:" + searchX + ", newp value:" + searchValue);
									/*for(int a = 0; a<counter; a++){
										searchX -= j;
										searchY -= i;
										gameBoard[searchY][searchX] = playerColor;
									}*/
		                            return true;
		                        } //If end of the direction is empty , then stop search this direction.
		                        else if (searchValue == empty) {
		                            found = true;
		                            //System.out.println("empty : true, Y:" + searchY + ", X:" + searchX);
		                        } //counter++;
		                    }
		                }

		            }
		            //System.out.println("false");
		            return false;
		        }
		        //System.out.println("false");
		        return false;

		    }
		
		public int[][] Flip(int y, int x, int[][] gameBoard, boolean playerTurn) {

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
			                    if ((searchX >= 8 || searchX < 0) || (searchY >= 8 || searchY < 0)) {
			                            System.out.println("Over bound! Y:" + searchY +" X: " +searchX + " i:" + i +" j: " + j);
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
										System.out.println("FLIP "+counter+" PIECE(S)");
										for(int a = 0; a<counter; a++){
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
			                        } counter++;
			                    }
			                }

			            }
			            //System.out.println("false");
			            //return gameBoard;
			        return gameBoard;

			    }
		
	//change to string as output
	/*public String WinningCondition(int[][] currentGameBoard) {
		for(x=0;x<boardSizeX;x++){	
			for(y=0;y<boardSizeY;y++){
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
