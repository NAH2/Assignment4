import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import boardGame.*;
import piece.*;

public class GUI extends JFrame {

	public GameController getGame() {
		return m_game;
	}

	public BoardGame getBoard() {
		return m_board;
	}

	public JPanel[][] getPanels() {
		return m_panels;
	}

	public boolean setPassButton() {
		m_passMove.setVisible(true);
		m_frame.pack();

		return true;
	}
	
	public boolean setOthelloInfo(){
		playerOneColor.setText(m_game.getPlayerName("black")+":");
		playerOneColor.setFont(f);
		playerOneColor.setVisible(true);
		OthelloPiece black = new OthelloPiece("black");
		playerOneIcon.setIcon(black.getIcon());
		playerOneIcon.setVisible(true);
		playerTwoColor.setText(m_game.getPlayerName("white")+":");
		playerTwoColor.setFont(f);
		playerTwoColor.setVisible(true);
		OthelloPiece white = new OthelloPiece("white");
		playerTwoIcon.setIcon(white.getIcon());
		playerTwoIcon.setVisible(true);
		playerTurnIcon.setIcon(new OthelloPiece(m_game.getCurrent()).getIcon());
		playerTurnIcon.setVisible(true);
		playerTurnLabel.setText("'s TURN");
		playerTurnLabel.setFont(f);
		playerTurnLabel.setVisible(true);
		blackIcon.setIcon(black.getIcon());
		blackIcon.setVisible(true);
		blackPieces.setText(((Othello)(m_board)).GetBlackScore()+"");
		blackPieces.setFont(f);
		blackPieces.setVisible(true);
		whiteIcon.setIcon(white.getIcon());
		whiteIcon.setVisible(true);
		whitePieces.setText(((Othello)(m_board)).GetWhiteScore()+"");
		whitePieces.setFont(f);
		whitePieces.setVisible(true);
		m_passMove.setVisible(true);
		m_frame.pack();
		return true;
	}
	
	public boolean setConnectFourInfo(){
		playerTurnIcon.setIcon(new ConnectFourPiece(m_game.getCurrent()).getIcon());
		playerTurnIcon.setVisible(true);
		playerTurnLabel.setText("'s TURN");
		playerTurnLabel.setFont(f);
		playerTurnLabel.setVisible(true);
		return true;
	}
	
	public boolean updatePlayerTurnIcon(Icon picon){
		playerTurnIcon.setIcon(picon);
		return true;
	}
	
	public boolean updateScore(int black, int white){
		blackPieces.setText(black+"");
		whitePieces.setText(white+"");
		return true;
	}

	public GUI(BoardGame b, GameController g) {
		m_board = b;
		m_game = g;
		m_width = m_board.GetWidth();
		m_height = m_board.GetHeight();
		m_panels = new JPanel[m_width][m_height];
		m_labels = new JLabel[m_width][m_height];
		m_icon = new ImageIcon(getClass().getResource(m_iconURL));
		draw();
	}

	public void draw() {
		m_frame = new JFrame("Game");
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.ipadx = 15;

		JPanel gamePanel = new JPanel(new GridLayout(m_height, m_width));
		mainPanel.add(gamePanel, c);

		/*m_passMove = new JButton("Pass");
		c.gridx = 1;
		c.gridy = 2;
		mainPanel.add(m_passMove, c);
		m_passMove.setVisible(false);

		m_newGame = new JButton("New Game");
		c.gridx = 1;
		c.gridy = 0;
		mainPanel.add(m_newGame, c);
		m_newGame.setVisible(true);*/
		
        JPanel infoPanel = new JPanel(new GridLayout(6,2));
        playerOneColor = new JLabel();
        playerOneColor.setVisible(false);
        infoPanel.add(playerOneColor);
        //playerOneColor.setVisible(true);    
        playerOneIcon = new JLabel();
        infoPanel.add(playerOneIcon);
        playerOneIcon.setVisible(false);
        playerTwoColor = new JLabel();     
        playerTwoColor.setVisible(false);
        infoPanel.add(playerTwoColor);
        //playerOneIcon.setVisible(true);       
        playerTwoIcon = new JLabel();
        playerTwoIcon.setVisible(false);
        infoPanel.add(playerTwoIcon);      
        playerTurnIcon = new JLabel();
        playerTurnIcon.setVisible(false);
        infoPanel.add(playerTurnIcon);       
        playerTurnLabel = new JLabel();
        playerTurnLabel.setVisible(false);
        infoPanel.add(playerTurnLabel);       
        //JLabel whiteIcon = new JLabel();        
        blackIcon = new JLabel();
        blackIcon.setVisible(false);
        infoPanel.add(blackIcon);
        blackPieces = new JLabel();
        blackPieces.setVisible(false);
        infoPanel.add(blackPieces);
        whiteIcon = new JLabel();
        whiteIcon.setVisible(false);
        infoPanel.add(whiteIcon);       
        whitePieces = new JLabel();
        whitePieces.setVisible(false);
        infoPanel.add(whitePieces); 
		m_newGame = new JButton("New Game");
		infoPanel.add(m_newGame);
		m_newGame.setVisible(true);   
        m_passMove = new JButton("Pass");
		infoPanel.add(m_passMove);
		m_passMove.setVisible(false);    
        

		GUIHandler handler = new GUIHandler();
		for (int y = 0; y < m_height; ++y) {
			for (int x = 0; x < m_width; ++x) {
				m_panels[x][y] = new JPanel();
				m_panels[x][y].setPreferredSize(new Dimension(70, 70));
				m_labels[x][y] = new JLabel();
				m_panels[x][y].addMouseListener(handler);
				gamePanel.add(m_panels[x][y]);
			}
		}
		m_passMove.addActionListener(handler);
		m_newGame.addActionListener(handler);

		m_frame.add(mainPanel, BorderLayout.WEST);
		m_frame.add(infoPanel, BorderLayout.EAST);

		m_frame.pack();
		m_frame.setLocationRelativeTo(null);
		m_frame.setVisible(true);
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void drawPieces() {
		for (int y = 0; y < m_height; ++y) {
			for (int x = 0; x < m_width; ++x) {
				GamePiece p = m_board.getPiece(x, y);

				if (p != null) {
					m_labels[x][y].setIcon(p.getIcon());
					m_panels[x][y].removeAll();
				}
				m_panels[x][y].add(m_labels[x][y]);
			}
		}
		SwingUtilities.updateComponentTreeUI(m_frame);
		if(m_board instanceof Othello){
			updatePlayerTurnIcon(new OthelloPiece(m_game.getCurrent()).getIcon());
			updateScore(((Othello)(m_board)).GetBlackScore(),((Othello)(m_board)).GetWhiteScore());
		} else {
			updatePlayerTurnIcon(new ConnectFourPiece(m_game.getCurrent()).getIcon());
		}
	}

	public void showWinningBox() {
		if (m_board.getWinningColour().equals("draw")) {
			JOptionPane.showMessageDialog(m_frame, "GAME DRAWN", "Draw",
					JOptionPane.OK_OPTION, m_icon);
		} else {
			JOptionPane.showMessageDialog(m_frame,
					m_game.getPlayerName(m_board.getWinningColour())
							+ "   WINS!!!!", "Winner", JOptionPane.OK_OPTION,
					m_icon);
		}

		// System.exit(0);
		SelectGame sg = new SelectGame();
		sg.Draw();
		m_frame.dispose();
	}

	private class GUIHandler implements MouseListener, ActionListener {
		// these methods had to be declared as MouseListener is abstract
		public void mousePressed(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
			boolean moveComplete = false;
			if (m_game.getGamOn()) {
				for (int y = 0; y < m_height; y++) {
					for (int x = 0; x < m_width; ++x) {
						if (e.getSource() == m_panels[x][y]) {
							moveComplete = m_board.Move(x, y,
									m_game.getCurrent());
						}
					}
				}
				if (moveComplete) {
					m_game.alternate();
					drawPieces();
					if (m_game.checkWin()) {
						showWinningBox();
					}
					// System.out.println(m_board.toString());
				}
			}
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == m_passMove) {
				if (m_game.getGamOn()) {
					if (((Othello) m_board).CheckPassTurn()) {
						m_game.alternate();
					}
				}
			}

			if (e.getSource() == m_newGame) {
				SelectGame sg = new SelectGame();
				sg.Draw();
				m_frame.dispose();
			}
		}
	}
	
	private Font f = new Font("Dialog", Font.PLAIN, 15);
	private JLabel playerOneColor, playerOneIcon, playerTwoColor, playerTwoIcon, playerTurnIcon, 
	playerTurnLabel, whiteIcon, whitePieces, blackIcon, blackPieces;
	private BoardGame m_board;
	private GameController m_game;
	protected JPanel[][] m_panels;
	private int m_width;
	private int m_height;
	private JLabel[][] m_labels;
	private JFrame m_frame;
	private JButton m_passMove;
	private JButton m_newGame;
	private Icon m_icon;
	private String m_iconURL = "icon.png";
}
