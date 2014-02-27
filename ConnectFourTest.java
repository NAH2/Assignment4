

import static org.junit.Assert.*;

import org.junit.Test;
import Player.HumanPlayer;
import boardGame.*;

public class ConnectFourTest {

	HumanPlayer p1 = new HumanPlayer("Jim", "red");
	HumanPlayer p2 = new HumanPlayer("Bob", "yellow");
	GameController g = new GameController("connectFour");
	ConnectFour c4 = new ConnectFour();
	
	/**
	 * Invalid colour is tested in ConnectFourPieceTest
	 */
	@Test
	public void testSetPiece() {
		assertTrue(c4.SetPiece(9,6,"red"));
		assertTrue(c4.SetPiece(0,0,"yellow"));
		assertFalse(c4.SetPiece(9, 7, "red"));
		assertFalse(c4.SetPiece(10, 8, "yellow"));
		assertFalse(c4.SetPiece(-1, -1, "yellow"));
	}
	
	@Test
	public void testMove() {
		assertTrue(c4.Move(9,6,"red"));
		assertTrue(c4.Move(9,1,"yellow"));
		assertTrue(c4.Move(9,6,"red"));
		assertTrue(c4.Move(9,1,"yellow"));
		assertTrue(c4.Move(9,2,"red"));
		assertTrue(c4.Move(9,3,"yellow"));
		assertTrue(c4.Move(9,4,"red"));
		assertFalse(c4.Move(9,7,"red"));
	}
	
	@Test
	public void testWinningCondition() {
		assertFalse(c4.WinningCondition());
		c4.Move(9,6,"red");
		c4.Move(9,6,"red");
		c4.Move(9,6,"red");
		c4.Move(9,6,"red");
		assertTrue(c4.WinningCondition());
	}
	
	@Test
	public void testSetWinner(){
		assertFalse(c4.SetWinner());
		c4.Move(9,6,"red");
		c4.Move(9,6,"red");
		c4.Move(9,6,"red");
		c4.Move(9,6,"red");
		assertTrue(c4.SetWinner());
	}

}
