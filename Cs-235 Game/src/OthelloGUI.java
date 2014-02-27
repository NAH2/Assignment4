import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

import piece.GamePiece;
import piece.OthelloPiece;
import boardGame.*;

public class OthelloGUI extends GUI {

	public OthelloGUI(BoardGame b, GameController g) {
		super(b, g);
		setOthelloInfo();
	}

	public boolean setOthelloInfo(){
		playerOneColor.setText(m_game.getPlayerName("black")+":");
		playerOneColor.setFont(f);
		playerOneColor.setVisible(true);
		OthelloPiece black = new OthelloPiece("black");
		playerOneIcon.setIcon(black.GetIcon());
		playerOneIcon.setVisible(true);
		playerTwoColor.setText(m_game.getPlayerName("white")+":");
		playerTwoColor.setFont(f);
		playerTwoColor.setVisible(true);
		OthelloPiece white = new OthelloPiece("white");
		playerTwoIcon.setIcon(white.GetIcon());
		playerTwoIcon.setVisible(true);
		playerTurnIcon.setIcon(new OthelloPiece(m_game.getCurrent()).GetIcon());
		playerTurnIcon.setVisible(true);
		playerTurnLabel.setText(m_game.getPlayerName(m_game.getCurrent()) + "'s TURN");
		playerTurnLabel.setFont(f);
		playerTurnLabel.setVisible(true);
		blackIcon.setIcon(black.GetIcon());
		blackIcon.setVisible(true);
		blackPieces.setText(((Othello)(m_board)).GetBlackScore()+"");
		blackPieces.setFont(f);
		blackPieces.setVisible(true);
		whiteIcon.setIcon(white.GetIcon());
		whiteIcon.setVisible(true);
		whitePieces.setText(((Othello)(m_board)).GetWhiteScore()+"");
		whitePieces.setFont(f);
		whitePieces.setVisible(true);
		m_passMove.setVisible(true);
		m_frame.pack();
		return true;
	}
	
	public boolean updateScore(int black, int white){
		blackPieces.setText(black+"");
		whitePieces.setText(white+"");
		return true;
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
