
/**
 *
 * @author Matt
 * */

public class HumanPlayer extends Player{

    private String playerName;
    private boolean playerTurn;
    private GamePiece piece;
    
    private HumanPlayer(){}
    
    public HumanPlayer(String playName, boolean playerTurn, GamePiece gamePiece) {
        SetPlayerName(playName);
        SetPlayerTurn(playerTurn);
        SetPieceColor(gamePiece);
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

    public GamePiece GetPiece() {
        return piece;
    }

    public void SetPieceColor(GamePiece gamePiece) {
        piece = gamePiece;
    }



    
    /**
     * For testing purposes have a main method.
     */
    public static void main(String args[]){
    	HumanPlayer humanPlayer = new HumanPlayer();
    }
}
