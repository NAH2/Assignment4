/**
 * \file -Player.java 
 * \author -Mathew Lloyd 711293 
 * \date -20th Feb 14
 * 
 * \see HumanPlayer.java
 * \see http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
 * 
 * \brief Parent class of methods for HumanPlayer.java
 * 
 * This abstract class is the parent object for the different types of players,
 * it contains accessor methods for player data and abstract method declarations
 */

public abstract class Player {

	/** \return m_pieceColor players piece colour */
	public String GetPiece() {
		return m_pieceColor;
	}
	
	/** \return m_playerName the players name */
	public String GetPlayerName() {
		return m_playerName;
	}
	/** 
	 * Accessor method to get the players turn.
	 * 		\return m_playerTurn true if it is players turn
	 * 		\return m_playerTurn false if it is not the players turn
	 */
	public boolean GetPlayerTurn() {
		return m_playerTurn;
	}

	/** Abstract accessor method to set the piece colour for the player.
	 * \param gamePiece a String containing the colour of the gamePiece
	 */
	public abstract void SetPieceColor(String gamePiece);
	
	/** Abstract accessor method to set the players name.
	 *  \param settingPlayerName settingPlayerName = the players name that gets set.
	 */
	public abstract void SetPlayerName(String settingPlayerName);

	/** 
	 * Abstract accessor method to set the players turn.
	 * \param settingPlayerTurnsetting whether it's the players turn or not.
	 * 		true = players turn
	 * 		false = not the players turn
	 */
	public abstract void SetPlayerTurn(boolean settingPlayerTurn);

	

	/**
	 * For testing purposes have a main method.
	 */
	public static void main(String args[]) {
	}
	
	/** The players set name */
	protected String m_playerName;
	/** Boolean of whether it is players turn*/
	protected boolean m_playerTurn;
	/** The players piece colour */
	protected String m_pieceColor;
}