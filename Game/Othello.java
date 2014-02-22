//May need getplayerName() from SELECTION class
import java.awt.Color;
public class Othello extends Game {

	private int[][] gameBoard, newPiecePosition;
	private int scoreWhite, scoreBlack, boardSize = 8, x, y, startingScore = 0;
	private boolean playerTurn;
	private int empty = 0,black = 1, white = 2;
	
	//add playerTurn as parameter, maybe 2d array board as output(set available markers as value 3 in the array)?
	/*private boolean SetAvailMarkers(int[][] move, boolean playerTurn){
		//
		gameBoard.setUpdate(move);
	}*/
	
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
	/*
	public int GetScoreWhite() {
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
	/*
	public int[][] GetNewPiecePosition() {
	}
	
	public boolean AvailableMove(int[][] gameBoard, boolean playerTurn) {
	}
	
	public boolean ChangePieces(int[][] newPiecePosition) {
	}
	
	public boolean Game(int boardSize, boolean playerTurn) {
	}
	
	public boolean Move(int[][] placePiece, int[][] gameBoard, boolean playerTurn) {
	}*/
	
	//Not complete
	public boolean ValidMove(int x, int y, int[][] gameBoard) {
		//if selection.getPlayerColor() == Color.BLACK , i.e. player = black
		//for(int i=0;i<boardSize;i++){
			//for(int j=0;j<boardSize;j++){
				if(gameBoard[x][y] != 0){
					System.out.println("false");
					return false;
				} else if ((x != boardSize-1)&&(x != 0 )&&(y != boardSize-1)&&(y != 0)){
					if(gameBoard[x+1][y] != 2 && gameBoard[x][y+1] != 2 && gameBoard[x-1][y] != 2 && gameBoard[x][y-1] != 2 && gameBoard[x+1][y+1] != 2 && gameBoard[x-1][y+1] != 2 && gameBoard[x+1][y-1] != 2 && gameBoard[x-1][y-1] != 2){ //EVERY CASE for boardsize - x, IF GAMEBOARD=1  return true 
						System.out.println("false"); 
						return false;
						} else {
							System.out.println("true"); 
						return true;
						}
				} else {
					System.out.println("edge"); return false;
				}
			//}
		//}
		
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
