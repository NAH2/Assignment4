import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import boardGame.*;
import piece.*;

public class GUI extends JFrame {

	public GameController GetGame() {
		return m_game;
	}

	public BoardGame GetBoard() {
		return m_board;
	}

	public JPanel[][] GetPanels() {
		return m_panels;
	}
	
	public boolean UpdatePlayerTurnIcon(Icon picon){
		playerTurnIcon.setIcon(picon);
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
		Draw();
	}

	public void Draw() {
		m_frame = new JFrame("Game");
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.ipadx = 15;

		JPanel gamePanel = new JPanel(new GridLayout(m_height, m_width));
		mainPanel.add(gamePanel, c);
		
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

	public void DrawPieces() {
		for (int y = 0; y < m_height; ++y) {
			for (int x = 0; x < m_width; ++x) {
				GamePiece p = m_board.GetPiece(x, y);

				if (p != null) {
					m_labels[x][y].setIcon(p.GetIcon());
					m_panels[x][y].removeAll();
				}
				m_panels[x][y].add(m_labels[x][y]);
			}
		}
		SwingUtilities.updateComponentTreeUI(m_frame);
	}

	public void ShowWinningBox() {
		if (m_board.GetWinningColour().equals("draw")) {
			JOptionPane.showMessageDialog(m_frame, "GAME DRAWN", "Draw",
					JOptionPane.OK_OPTION, m_icon);
		} else {
			JOptionPane.showMessageDialog(m_frame,
					m_game.GetPlayerName(m_board.GetWinningColour())
							+ "   WINS!!!!", "Winner", JOptionPane.OK_OPTION,
					m_icon);
		}
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
									m_game.GetCurrent());
						}
					}
				}
				if (moveComplete) {
					m_game.alternate();
					DrawPieces();
					if (m_game.checkWin()) {
						ShowWinningBox();
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
						UpdatePlayerTurnIcon(new OthelloPiece(m_game.GetCurrent()).GetIcon());
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
	
	protected Font f = new Font("Dialog", Font.PLAIN, 15);
	protected JLabel playerOneColor, playerOneIcon, playerTwoColor, playerTwoIcon, playerTurnIcon, 
	                 playerTurnLabel, whiteIcon, whitePieces, blackIcon, blackPieces;
	protected BoardGame m_board;
	protected GameController m_game;
	protected JPanel[][] m_panels;
	protected int m_width;
	protected int m_height;
	protected JLabel[][] m_labels;
	protected JFrame m_frame;
	protected JButton m_passMove;
	private JButton m_newGame;
	private Icon m_icon;
	private String m_iconURL = "icon.png";
}