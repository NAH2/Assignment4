import static org.junit.Assert.*;

import org.junit.Test;

import boardGame.ConnectFour;

import Player.HumanPlayer;


public class Connect4GUITest {
	HumanPlayer p1 = new HumanPlayer("Jim", "black");
	HumanPlayer p2 = new HumanPlayer("Bob", "white");
	ConnectFour C4 = new ConnectFour();
	GameController game = new GameController("othello", p1, p2);
	Connect4GUI C4GUI = new Connect4GUI(C4, game);
	

	@Test
	public void testSetConnectFourInfo() {
		assertTrue(C4GUI.setConnectFourInfo());
	}

	@Test
	public void testSetPanelColour() {
		assertTrue(C4GUI.SetPanelColour());
	}

}
