

import static org.junit.Assert.*;

import org.junit.Test;
import boardGame.*;

public class OthelloTest {
	GameController game = new GameController("othello") ;
    Othello othello = new Othello() ;
	@Test
	public void testGetWidth() {
		assertEquals(8,othello.GetWidth());
	}
	@Test
	public void testGetHigh() {
		assertEquals(8,othello.GetHeight());
	}
	@Test
	public void testGetWhiteScore() {
		assertEquals(2,othello.GetWhiteScore());
	}
	@Test
	public void testGetBlackScore() {
		assertEquals(2,othello.GetWhiteScore());
	}
	
	public void testAvailableMove(){
		assertEquals(,othello.AvailableMove("black"))
	}
}
