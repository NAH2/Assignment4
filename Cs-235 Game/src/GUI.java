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
    
    public GUI(BoardGame b, GameController g) {
        m_board = b;
        m_game = g;
        m_width = m_board.getWidth();
        m_height = m_board.getHeight();
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
        
        JPanel gamePanel = new JPanel(new GridLayout(m_height,m_width));
        mainPanel.add(gamePanel,c);
        
        m_passMove = new JButton("Pass");
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(m_passMove,c);
        m_passMove.setVisible(false);
        
        GUIHandler handler = new GUIHandler();
        for (int y = 0; y < m_height; ++y) {
            for (int x = 0; x < m_width; ++x) {
                m_panels[x][y] = new JPanel();
                m_panels[x][y].setPreferredSize(new Dimension(70,70));
                m_labels[x][y] = new JLabel();
                m_panels[x][y].addMouseListener(handler);
                gamePanel.add(m_panels[x][y]);
            }
        }
        m_passMove.addActionListener(handler);
        
        m_frame.add(mainPanel);
        //frame.setLocationRelativeTo(null);
        
        m_frame.pack();
        m_frame.setVisible(true);
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void drawPieces() {
        for (int y  = 0; y < m_height; ++y) {
            for (int x = 0; x < m_width; ++x) {
                GamePiece p = m_board.getPiece(x,y);
                
                if (p != null) {
                    m_labels[x][y].setIcon(p.getIcon());
                    m_panels[x][y].removeAll();
                }
                m_panels[x][y].add(m_labels[x][y]);
            }
        }
        SwingUtilities.updateComponentTreeUI(m_frame);    
    }
    
    public void showWinningBox() {
        
        JOptionPane.showMessageDialog(m_frame,
                m_game.getPlayerName(m_board.getWinningColour()) + "   WINS!!!!", "Winner",
                JOptionPane.OK_OPTION, m_icon);
        
       //System.exit(0);
        SelectGame sg = new SelectGame();
        sg.Draw();
        m_frame.dispose();
    }
    
    private class GUIHandler implements MouseListener, ActionListener {
     // these methods had to be declared as MouseListener is abstract
        public void mousePressed(MouseEvent e){    }
        public void mouseClicked(MouseEvent e) {    }
        public void mouseEntered(MouseEvent e) {    }
        public void mouseExited(MouseEvent e) {    }
        
        public void mouseReleased(MouseEvent e) {
            boolean moveComplete = false;
            if (m_game.getGamOn()) {
                for (int y = 0; y < m_height; y++) {
                    for (int x = 0; x < m_width; ++x) {
                        if (e.getSource() == m_panels[x][y]) {
                            moveComplete = m_board.move(x, y, m_game.getCurrent());
                        }
                    }
                }
                if (moveComplete) {
                    m_game.alternate();
                    drawPieces();
                    if (m_game.checkWin()) {
                        showWinningBox();
                    }
                    //System.out.println(m_board.toString());
                }
            }
        }
        
        public void actionPerformed(ActionEvent e) {
            if (m_game.getGamOn()) {
                if (((Othello) m_board).checkPassTurn()) {
                    m_game.alternate();
                }
            }
        }
    }
    
    private BoardGame m_board;
    private GameController m_game;
    protected JPanel[][] m_panels;
    private int m_width;
    private int m_height;
    private JLabel[][] m_labels;
    private JFrame m_frame;
    private JButton m_passMove;
    private Icon m_icon;
    private String m_iconURL = "icon.png";
}
