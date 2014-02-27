package Player;

/**
 * \file -HumanPlayer.java 
 * \author -Mathew Lloyd 711293 
 * \date -20th Feb 14
 * 
 * \see Player.java
 * 
 * \brief HumanPlayer, used to store data about the player, extends Player.java
 * 
 * This class extends from the Player class. It inherits the accessor methods,
 * implements the methods in it's own way that differs to other player types.
 */

public class HumanPlayer extends Player {

	/**
	 * An accessor method to retrieve the players name from the Player class.
	 * \return m_playerName returns the player name retrieves from Player class
	 */
	public String GetPlayerName() {
		boolean test = true;
		if (test || m_test) {
            System.out.println("HumanPlayer :: GetPlayerName() BEGIN");
            }
		
		if (test || m_test) {
			System.out.println("HumanPlayer :: GetPlayerName() END");
		}
		
		return m_playerName;
	
		
	}

	/**
	 * An accessor method to retrieve the players colour piece 
	 * \return m_pieceColor the players colour. 
	 * 
	 * retrieves from Player class
	 */
	public String GetPiece() {
		boolean test = true;
		if (test || m_test) {
            System.out.println("HumanPlayer :: GetPiece() BEGIN");
            }
		
		if (test || m_test) {
			System.out.println("HumanPlayer :: GetPiece() END");
		}
		
		
		
		return m_pieceColor;
	}

	/**
	 * An accessor method to set the players name. 
	 * \param settingPlayerName parameter comes from the constructor, 
	 * sets the players name in the Player class.
	 */
	public boolean SetPlayerName(String settingPlayerName) {
		boolean test = true;
		if (settingPlayerName.isEmpty() && (test == true)) {
			System.err
			.println("*** Warning HumanPlayer::SetPlayerName() name set to empty string.");
		}
		m_playerName = settingPlayerName;
		return true;
	}

	/**
	 * An accessor method to set the players game piece colour. 
	 * \param gamePiece parameter comes from the constructor sets 
	 * the players piece colour in the Player class.
	 *  Has if statement to make sure that there are only 4 possible inputs
	 */
	public boolean SetPieceColor(String gamePiece) {
		boolean test = true;
		if (gamePiece.isEmpty() && (test == true)) {
			System.err
			.println("*** Warning HumanPlayer::SetPlayerName() gamePiece set to empty string.");
		}
		if (gamePiece.equalsIgnoreCase("red")
				|| gamePiece.equalsIgnoreCase("yellow")
				|| gamePiece.equalsIgnoreCase("black")
				|| gamePiece.equalsIgnoreCase("white")) {
			m_pieceColor = gamePiece.toLowerCase();
			return true;
		} else {
			System.err
			.println("Invalid Entry, only red,yellow,black or White. Entered: "
					+ gamePiece);
		}
		return false;
	}

	/** No argument constructor for testing purposes */
	private HumanPlayer() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("HumanPlayer :: HumanPlayer() BEGIN");
		}
        if (test || m_test) {
            System.out.println("HumanPlayer :: HumanPlayer() END");
        }
	}
	
	/**
	 * This is the constructor for the player calls to set the player name, turn
	 * and piece colour
	 * 
	 * \param playName a String that contains the players name 
	 * \param gamePiece sets the players piece colour
	 * 
	 */
	public HumanPlayer(String playName, String gamePiece) {
		boolean test = false;
		if (test || m_test) {
            System.out.println("HumanPlayer :: HumanPlayer() BEGIN");
        }
		
		SetPlayerName(playName);
		SetPieceColor(gamePiece);
		
		if (test || m_test) {
            System.out.println("HumanPlayer :: HumanPlayer() END");
        }
	}
	
	/**
	 * Testing in the main method.
	 */
	public static void main(String args[]) {
		boolean test = true;
		if (test == true) {
			System.out.println("HumanPlayer::main() BEGIN unit test");
		}
		/** Invalid Entry: */
		HumanPlayer humanPlayer = new HumanPlayer();
		humanPlayer.SetPlayerName("");
		humanPlayer.SetPlayerName("Proper Name Player");
		/** invalid entries of piece Color */
		humanPlayer.SetPieceColor("1,2");
		humanPlayer.SetPieceColor("yellow 1");
		humanPlayer.SetPieceColor("");
		/** Valid Entries: */
		humanPlayer.SetPieceColor("yellow");
		/** Print statements to test setting of piece colour */
		System.out.println("HumanPlayer test:: Piece: "
				+ humanPlayer.GetPiece());
		humanPlayer.SetPieceColor("red");
		System.out.println("HumanPlayer test:: Piece: "
				+ humanPlayer.GetPiece());
		humanPlayer.SetPieceColor("black");
		System.out.println("HumanPlayer test:: Piece: "
				+ humanPlayer.GetPiece());
		humanPlayer.SetPieceColor("white");
		System.out.println("HumanPlayer test:: Piece: "
				+ humanPlayer.GetPiece());
		System.out.println("HumanPlayer test:: PlayerName: "
				+ humanPlayer.GetPlayerName());
		if (test == true) {
			System.out.println("HumanPlayer::main() END unit test");
		}
	}
	/** Indicates whether to run tests */
    private boolean m_test = false;
}
