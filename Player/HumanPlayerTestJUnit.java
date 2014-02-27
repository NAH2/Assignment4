package Player;

import static org.junit.Assert.*;

import org.junit.Test;

public class HumanPlayerTestJUnit {
	
	HumanPlayer hp = new HumanPlayer("JUnit test", "yellow");
	@Test
	public void testGetPiece() {
		assertEquals("yellow", hp.GetPiece());
		
	}
	
	@Test
	public void testGetPlayerName() {
		
		assertTrue("JUnit test" ==  hp.GetPlayerName());
	}

	@Test
	public void testSetPieceColor() {
		/**invalid entries of piece Color*/
    	hp.SetPieceColor("1,2");
    	assertFalse("1,2" == hp.GetPiece());
    	hp.SetPieceColor("yellow 1");
    	assertFalse("yellow 1" == hp.GetPiece());
    	hp.SetPieceColor("");
    	assertFalse("" == hp.GetPiece());
    	hp.SetPieceColor("green");
		assertFalse("green" ==  hp.GetPiece());
		
    	/**Valid Entries:*/
    	hp.SetPieceColor("yellow");
    	assertEquals("yellow", (hp.GetPiece()));
    	hp.SetPieceColor("red");
    	assertEquals("red", (hp.GetPiece()));
    	hp.SetPieceColor("black");
    	assertEquals("black", (hp.GetPiece()));
    	hp.SetPieceColor("white");
    	assertEquals("white", (hp.GetPiece()));
	}

	@Test
	public void testSetPlayerName() {
		hp.SetPlayerName("Proper Name Player");
		assertEquals("Proper Name Player", hp.GetPlayerName());
		hp.SetPlayerName("");
		assertEquals("", hp.GetPlayerName());
	}

}
