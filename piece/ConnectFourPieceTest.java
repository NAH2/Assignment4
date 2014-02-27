package piece;

import static org.junit.Assert.*;

import org.junit.Test;
/** This is a test class
*  \see ConnectFourPiece.java , GamePiece.java
*
* \brief This class tests the ConnectFourPiece
*
* The ConnectFourPiece was tested with invalid colours that are valid for 
* the other class. There was also tests of numebrs which shouldn't be allowed
* and there was tests for setting the Icons. As ConnectFourPiece inherits from
* GamePiece.java therefore this goes towards testing that class.
*/
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
