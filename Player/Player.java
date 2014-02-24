package Player;

public abstract class Player {
	
	private String playerName;
    private boolean playerTurn;
    private GamePiece pieceColor;

    public String GetPlayerName() {
    	return playerName;
    	}
    
    public void SetPlayerName(String settingPlayerName) {}

    public boolean GetPlayerTurn() {
    	return playerTurn;
    }
    
    public void SetPlayerTurn(boolean settingPlayerTurn) {}

    public GamePiece GetColor() {
    	return pieceColor;
    }

    public void SetPieceColor(GamePiece colorPiece) {}



    
    /**
     * For testing purposes have a main method.
     */
    public static void main(String args[]){
    }
}