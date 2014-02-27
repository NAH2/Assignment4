/**
 * \file -GameController.java 
 * \author -
 * \date -22nd Feb 14
 * 
 * \brief GameController is used to control the game flow. 
 * 
 * This class monitor the game status, it checks the winning condition and change the player turn.
 */
 
import Player.*;
import boardGame.*;

public class GameController {

		 /**
     * Get whether the game is finished or not.
     * \return boolean  return true if the game is on.
     */
     
	public boolean GetGamOn() {
		return m_gameOn;
	}

	 /**
     * Set whether the game is finished or not.
     * \param the situation of the the game.
     * \return boolean  return true if the game is on.
     */
	public boolean SetGameOn(boolean win) {
		if (win) {
			m_gameOn = false;
		} else {
			m_gameOn = true;
		}
		return true;
	}

	 /**
     * Get player name.
     * \param the colour of a piece.
     * \return String  return the player name with the given colour.
     */
	public String GetPlayerName(String colour) {
		if (m_p1.GetPiece().equals(colour)) {
			return m_p1.GetPlayerName();
		} else {
			return m_p2.GetPlayerName();
		}
	}

	 /**
     * Get current player name.
     * \return String  return the name of the current player.
     */
	public String GetCurrent() {
		return m_currentPlayer.GetPiece();
	}

	 /**
	  * Exchange player turn in othello or connect four.
  */
	public void Alternate() {
		if (m_currentPlayer == m_p1) {
			m_currentPlayer = m_p2;
		} else if (m_currentPlayer == m_p2) {
			m_currentPlayer = m_p1;
		}
	
		if (m_gameType.equals(m_othello)) {
			m_othelloGUI.SetPanelColour();
			m_othelloGUI.SetOthelloInfo();
		} else if (m_gameType.equals(m_connectFour)) {
			m_c4GUI.SetPanelColour();
			m_c4GUI.setConnectFourInfo();
		}
	}

	 /**
	  * Check the winning condition of othello and connect four.
	  * return boolean  true when the game is finished.
  */
	public boolean CheckWin() {
		boolean win = false;
		if (m_gameType.equals(m_othello)) {
			win = m_othelloBoard.WinningCondition();
		} else if (m_gameType.equals(m_connectFour)) {
			win = m_connectFourBoard.WinningCondition();
		}
		SetGameOn(win);
		return win;
	}

	 /**
	  * Constructor of GameController.
	  * \param game type, the two HumanPlayer objects
    */
	public GameController(String gt, HumanPlayer one, HumanPlayer two) {
		m_p1 = one;
		m_p2 = two;
		m_currentPlayer = m_p1;
		m_gameType = gt;
		SetUp(m_gameType);
	}

	 /**
	  * It is used for testing.
	  * \param the game type.
    */
	public GameController(String gt) {
		m_gameType = gt;

		if (m_gameType.equals(m_othello)) {
			m_p1 = new HumanPlayer("Jim", "white");
			m_p2 = new HumanPlayer("Bob", "black");
		} else if (m_gameType.equals(m_connectFour)) {
			m_p1 = new HumanPlayer("Jim", "red");
			m_p2 = new HumanPlayer("Bob", "yellow");
		}
		m_currentPlayer = m_p1;
		// System.out.println("P1: " + m_p1.GetPiece());
		// System.out.println("P2: " + m_p2.GetPiece());

		SetUp(m_gameType);
	}

	 /**
	  * Set up the game board with given game type.
	  * \param the game type.
   */
	public void SetUp(String m_gameType) {
		// System.out.println(getCurrent());

		if (m_gameType.equals(m_othello)) {
			m_othelloBoard = new Othello();
			m_othelloGUI = new OthelloGUI(m_othelloBoard, this);
			m_othelloGUI.DrawPieces();
			m_othelloGUI.SetPanelColour();
		} else if (m_gameType.equals(m_connectFour)) {
			m_connectFourBoard = new ConnectFour();
			m_c4GUI = new Connect4GUI(m_connectFourBoard, this);
			m_c4GUI.SetPanelColour();
		}
	}

	 /**
	  * It is used for testing.
     */
	public static void main(String[] args) {
		GameController a = new GameController("m_connectFour");
		// GameController b = new GameController("m_othello");
	}

	private final String m_connectFour = "connectFour";
	private final String m_othello = "othello";
	private Connect4GUI m_c4GUI;
	private OthelloGUI m_othelloGUI;
	private Othello m_othelloBoard;
	private ConnectFour m_connectFourBoard;
	private String m_gameType;
	private boolean m_gameOn = true;
	private HumanPlayer m_p1;
	private HumanPlayer m_p2;
	private HumanPlayer m_currentPlayer;
}
