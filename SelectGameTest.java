import static org.junit.Assert.*;

import java.awt.event.*;
import javax.swing.*;
import org.junit.Test;
/**
* \see SelectGame.java
*
* \brief To test the SelectGame.java class
*
* There are only two methods that are able to be tested in this
* class. The second test fails as the method has no input parameters.
*
*/

public class SelectGameTest {

	@Test
	public void testDraw1() {
		SelectGame test = new SelectGame();
		test.Draw();
	}
	@Test
	public void testDraw(){
		SelectGame test = new SelectGame(11);
		test.Draw();
	}

}
