package Player;

/**
 *
 * @author Matt
 * */

public class HumanPlayer {

    private String playerName;
    private boolean playerTurn;
    private int pieceColor;
    
    private HumanPlayer(){}
    
    public HumanPlayer(String playName, boolean playerTurn, int pieceColor) {
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

    public int GetColor() {
        return pieceColor;
    }

    public void SetPieceColor(int colorPiece) {
        pieceColor = colorPiece;
    }


    public void SetPlayerText(String name) {
    }
    

    
    /**
     * For testing purposes have a main method.
     */
    public static void main(String args[]){
    	HumanPlayer humanPlayer = new HumanPlayer();
    }
}
