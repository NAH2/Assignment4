import Player.*;
import boardGame.*;

public class GameController {

	public boolean GetGamOn() {
		return m_gameOn;
	}

	public boolean SetGameOn(boolean win) {
		if (win) {
			m_gameOn = false;
		} else {
			m_gameOn = true;
		}
		return true;
	}

	public String GetPlayerName(String colour) {
		if (m_p1.GetPiece().equals(colour)) {
			return m_p1.GetPlayerName();
		} else {
			return m_p2.GetPlayerName();
		}
	}

	public String GetCurrent() {
		return m_currentPlayer.GetPiece();
	}

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

	public GameController(String gt, HumanPlayer one, HumanPlayer two) {
		m_p1 = one;
		m_p2 = two;
		m_currentPlayer = m_p1;
		m_gameType = gt;
		SetUp(m_gameType);
	}

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