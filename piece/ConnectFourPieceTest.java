package piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectFourPieceTest {

	ConnectFourPiece C4P;
	@Test
	public void testGetIcon() {
		/**Tests that there is still a piece being set
		 * (Invalid Tests)
		 * */
		C4P = new ConnectFourPiece("123");
		assertTrue(C4P.GetIcon() == null);
		C4P = new ConnectFourPiece("black");
		assertTrue(C4P.GetIcon() == null);
		C4P = new ConnectFourPiece("white");
		assertTrue(C4P.GetIcon() == null);
		
		/**Valid Tests*/
		C4P = new ConnectFourPiece("red");
		assertTrue(C4P.GetIcon() != null);
		C4P = new ConnectFourPiece("yellow");
		assertTrue(C4P.GetIcon() != null);
		
	}

	@Test
	public void testSetIcons() {
		System.out.println("SetIcons() Cannot be tested like this" +
				"but instead is tested by attempting to set pieces above.");
	}

	@Test
	public void testConnectFourPiece() {
		C4P = new ConnectFourPiece("black");
		assertTrue(C4P.SetIcons());
		C4P = new ConnectFourPiece("white");
		assertTrue(C4P.SetIcons());
		C4P = new ConnectFourPiece("yellow");
	}

}
