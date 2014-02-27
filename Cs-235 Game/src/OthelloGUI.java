import java.awt.Color;
import javax.swing.BorderFactory;
import boardGame.*;

public class OthelloGUI extends GUI {

	public OthelloGUI(BoardGame b, GameController g) {
		super(b, g);
		setPassButton();
		setOthelloInfo();
	}

	public boolean setPanelColour() {
		char[][] availableMoves = ((Othello) getBoard())
				.AvailableMove(getGame().getCurrent());
		Color defCol = new Color(170, 150, 100);
		for (int y = 0; y < getBoard().GetHeight(); ++y) {
			for (int x = 0; x < getBoard().GetWidth(); ++x) {
				m_panels[x][y].setBorder(BorderFactory
						.createLineBorder(Color.black));
				if (availableMoves[x][y] == 'O') {
					if ((getGame().getCurrent() == "black"))
						m_panels[x][y].setBackground(Color.blue);
					else
						m_panels[x][y].setBackground(Color.red);

				} else {
					m_panels[x][y].setBackground(defCol);
				}
			}
		}
		return true;
	}
}
