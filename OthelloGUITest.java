import static org.junit.Assert.*;

import org.junit.Test;

import Player.HumanPlayer;
import boardGame.Othello;


public class OthelloGUITest {
	 HumanPlayer p1 = new HumanPlayer("Jim", "black");
		HumanPlayer p2 = new HumanPlayer("Bob", "white");
	   Othello othello = new Othello();
   	GameController game = new GameController("othello", p1, p2);
   	OthelloGUI OthelloGUI = new OthelloGUI(othello, game);
		 
	 
	@Test
	public void testSetOthelloInfo() {
		assertTrue(OthelloGUI.SetOthelloInfo());
	}

	@Test
	public void testSetPanelColour(){
		assertTrue(OthelloGUI.SetPanelColour());
	}
} 
