package Player;
/**
 *
 * @author Matt
 * */

public class HumanPlayer extends Player{

    private String playerName;
    private boolean playerTurn;
    private GamePiece pieceColor;
    
    private HumanPlayer(){}
    
    public HumanPlayer(String playName, boolean playerTurn, GamePiece pieceColor) {
        SetPlayerName(playName);
        SetPlayerTurn(playerTurn);
        SetPieceColor(pieceColor);
    }

    public String GetPlayerName() {
        return playerName;
    }

    public void SetPlayerName(String settingPlayerName) {
        playerName = settingPlayerName;
    }

    public boolean GetPlayerTurn() {
        return playerTurn;
    }

    public void SetPlayerTurn(boolean settingPlayerTurn) {
        playerTurn = settingPlayerTurn;
    }

    public GamePiece GetColor() {
        return pieceColor;
    }

    public void SetPieceColor(GamePiece colorPiece) {
        pieceColor = colorPiece;
    }



    
    /**
     * For testing purposes have a main method.
     */
    public static void main(String args[]){
    	HumanPlayer humanPlayer = new HumanPlayer();
    }
}
