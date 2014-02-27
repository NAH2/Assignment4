import static org.junit.Assert.*;

import java.awt.event.*;
import javax.swing.*;
import org.junit.Test;


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
