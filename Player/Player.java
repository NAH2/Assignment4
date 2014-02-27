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
package Player;

public abstract class Player {

	/** \return m_pieceColor players piece colour */
	public String GetPiece() {
		return m_pieceColor;
	}
	
	/** \return m_playerName the players name */
	public String GetPlayerName() {
		return m_playerName;
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
	 * For testing purposes have a main method.
	 */
	public static void main(String args[]) {
	}
	
	/** The players set name */
	protected String m_playerName;
	/** The players piece colour */
	protected String m_pieceColor;
}