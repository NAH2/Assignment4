package piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class OthelloPieceTest {

	/**Tests both OthelloPiece.java and GamePiece.java*/
	OthelloPiece OthPiece;
	@Test
	public void testGetIcon() {
		OthPiece = new OthelloPiece("black");
		assertTrue(OthPiece.GetIcon() != null);
		OthPiece = new OthelloPiece("white");
		assertTrue(OthPiece.GetIcon() != null);
		/**Tests that there is still a piece being set*/
		OthPiece = new OthelloPiece("red");
		assertTrue(OthPiece.GetIcon() == null);
		OthPiece = new OthelloPiece("yellow");
		assertTrue(OthPiece.GetIcon() == null);
		OthPiece = new OthelloPiece("123");
		assertTrue(OthPiece.GetIcon() == null);
		
	}

	@Test
	public void testSetIcons() {
		System.out.println("SetIcons() Cannot be tested like this" +
				"but instead is tested by attempting to set pieces above.");
	}

	@Test
	public void testOthelloPiece() {
		OthPiece = new OthelloPiece("black");
		assertTrue(OthPiece.SetIcons());
		OthPiece = new OthelloPiece("white");
		assertTrue(OthPiece.SetIcons());
		OthPiece = new OthelloPiece("yellow");
	}

}
