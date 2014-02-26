
import java.awt.Color;
import javax.swing.UIManager;
import boardGame.*;

public class OthelloGUI extends GUI {

    public OthelloGUI(BoardGame b, GameController g) {
        super(b, g);
    }
    
    public boolean setPanelColour() {
        char[][] availableMoves = ((Othello) getBoard()).availableMove(getGame().getCurrent());
        Color defCol = new Color(170,150,100);
        for (int y = 0; y < getBoard().getHeight(); ++y) {
            for (int x = 0; x < getBoard().getWidth(); ++x) {
                if (availableMoves[x][y] == 'O') {
                    panels[x][y].setBackground(Color.cyan);
                } else {
                    panels[x][y].setBackground(defCol);
                }
            }
        }
        return true;
    }
}
