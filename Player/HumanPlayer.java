

/**
 *
 * @author Matt
 */
import java.awt.*;
import java.awt.event.MouseEvent;

public class HumanPlayer {

    private String playerName;
    private boolean playerTurn;
    private int pieceColor;
    private int gameType;
    private int[][] coord;

    private HumanPlayer(){}
    public HumanPlayer(String playName, boolean playerTurn, int pieceColor, int gameType) {
        this.playerName = playName;
        this.playerTurn = playerTurn;
        this.pieceColor = pieceColor;
        this.gameType = gameType;
    }

    public String GetPlayerName() {
        return this.playerName;
    }

    public void SetPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean GetPlayerTurn() {
        return this.playerTurn;
    }

    public void SetPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int GetColor() {
        return this.pieceColor;
    }

    public void SetPieceColor(int color) {
        this.pieceColor = color;
    }

    public void setPlayer(String playerType) {
    }

    public void setPlayerText(String name) {
    }

    public void placePiece(int[][] inCoord) {

        if (validMove(inCoord) == true) {
        	
        	if(gameType == 0){
        		Connect4.move(inCoord);
        	}else{
        		//Need to change input parameters on Othello.
        		Othello.Move(inCoord);
        	}
        	
        }

    }

    public boolean validMove(int[][] inCoord) {
    	//Need to change input parameters on Othello.
    	if(gameType == 0){
    		return Connect4.validMove();
    	}else{
    		return Othello.validMove();
    	}
       
        
    }

    public int[][] mouseReleased(MouseEvent e) {
        int[][] position = null;
        return position;
    }

    public int[][] lastPiecePlaced() {
        int[][] position = null;
        return position;
    }

    public void updateLastPiece(int[][] coord) {
    }
    
    /**
     * For testing purposes have a main method.
     */
    public static void main(String args[]){
    	HumanPlayer humanPlayer = new HumanPlayer();
    }
}
