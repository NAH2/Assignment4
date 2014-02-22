//May need getplayerName() from SELECTION class
import java.awt.Color;
public class Othello extends Game {

	private int[][] gameBoard, newPiecePosition;
	private int scoreWhite, scoreBlack, boardSizeX,boardSizeY, x, y, startingScore = 0;
	private boolean playerTurn;
	
	//add playerTurn as parameter, maybe 2d array board as output(set available markers as value 3 in the array)?
	private boolean SetAvailMarkers(int[][] move, boolean playerTurn){
		//
		gameBoard.setUpdate(move);
	}
	
	public boolean SetPlayer(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}
	
	public String GetFirstPlayer() {
		return ;//?  May need getplayerName() from selection class
	}
	
	//change boardsize to boardsize x,y
	//need calcWhiteScore and calcBlackScore from OthelloFB?
	public int GetScoreWhite() {
		scoreWhite = startingScore;
		for(x=0;x<boardSizeX;x++){	
			for(y=0;y<boardSizeY;y++){
				if(gameBoard[x][y] == /*e.g. 1or2?*/){
					scoreWhite++;
				}
			}
		}
		return scoreWhite;
	}
	
	public int GetScoreBlack() {
		scoreBlack = startingScore;
		for(x=0;x<boardSizeX;x++){	
			for(y=0;y<boardSizeY;y++){
				if(gameBoard[x][y] == /*e.g. 1or2?*/){
					scoreBlack++;
				}
			}
		}
		return scoreBlack;
	}
	
	public int[][] GetNewPiecePosition() {
	}
	
	public boolean AvailableMove(int[][] gameBoard, boolean playerTurn) {
	}
	
	public boolean ChangePieces(int[][] newPiecePosition) {
	}
	
	public boolean Game(int boardSize, boolean playerTurn) {
	}
	
	public boolean Move(int[][] placePiece, int[][] gameBoard, boolean playerTurn) {
	}
	
	public boolean ValidMove(int[][] move, int[][] gameBoard) {
		
	}
	
	//change to string as output
	public String WinningCondition(int[][] currentGameBoard) {
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
	}
	
}
