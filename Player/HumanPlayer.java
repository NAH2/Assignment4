/**
 * \file -Player.java 
 * \author -Mathew Lloyd 711293 
 * \date -20th Feb 14
 * 
 * \see Player.java
 * 
 * \brief HumanPlayer, used to store data about the player,
 * extends Player.java
 * 
 * This class extends from the Player class. It inherits the accessor methods,
 * implements the methods in it's own way that differes to other player types.
 */

public class HumanPlayer extends Player{

   /**
    * This is the constructor for the player
    * calls to set the player name, turn and piece colour
    * 
    * \param playName a String that contains the players name
    * \param playerTurn initializes this to true or false to set which player goes first
    * \param gamePiece sets the players piece colour
    * 
    */
    public HumanPlayer(String playName, boolean playerTurn, String gamePiece) {
        SetPlayerName(playName);
        SetPlayerTurn(playerTurn);
        SetPieceColor(gamePiece);
    }


    /**
     * An accessor method to retrieve the players 
     *  name from the Player class.
     *  \return m_playerName returns the player name
     *  retrieves from Player class
     */
    public String GetPlayerName(){
    	return m_playerName;
    }
    
    /** An accessor method to retrieve the players colour piece
     * \return m_pieceColor the players colour.
     * retrieves from Player class
     */
    public String GetPiece() {
        return m_pieceColor;
    }
    
    /** 
     * An accessor method to retrieve whether it's the
     *  players turn or not
     *  \return m_playerTurn (true = players turn, false = not players turn)
     * retrieves from Player class
     */
    public boolean GetPlayerTurn() {
    	return m_playerTurn;
    }
    
    
    

    /**
     * An accessor method to set the players name.
     * \param settingPlayerName parameter comes from the constructor,
     * sets the players name in the Player class.
     */
    public void SetPlayerName(String settingPlayerName) {
        m_playerName = settingPlayerName;
    }

    /**
     * An accessor method to set the players turn.
     * \param settingPlayerTurn parameter sets the whether it's
     * the players turn in the Player class.
     */
    public void SetPlayerTurn(boolean settingPlayerTurn) {
        m_playerTurn = settingPlayerTurn;
    }

    /**
     * An accessor method to set the players game piece colour.
     * \param gamePiece parameter comes from the constructor
     * sets the players piece colour in the Player class.
     */
    public void SetPieceColor(String gamePiece) {
        m_pieceColor = gamePiece;
    }
    
    


    
    /**
     * For testing purposes have a main method.
     */
    public static void main(String args[]){
    	HumanPlayer humanPlayer = new HumanPlayer("Player", true,"yellow");
    	System.out.println(humanPlayer.GetPlayerName());
    	System.out.println(humanPlayer.GetPiece());
    	System.out.println(humanPlayer.GetPlayerTurn());
    	
    }
}
