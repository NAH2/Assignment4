import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import boardGame.*;
import piece.*;

public class GUI extends JFrame {
    private BoardGame board;
    private GameController game;
    protected JPanel[][] panels;
    private int width;
    private int height;
    private JLabel[][] labels;
    private JFrame frame;
    JButton passMove;
    private Icon m_icon;
    private String m_iconURL = "icon.png";
    
    public GUI(BoardGame b, GameController g) {
        board = b;
        game = g;
        width = board.getWidth();
        height = board.getHeight();
        panels = new JPanel[width][height];
        labels = new JLabel[width][height];
        m_icon = new ImageIcon(getClass().getResource(m_iconURL));
        draw();
        
    }
    
    public void draw() {
        frame = new JFrame("Game");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        
        JPanel gamePanel = new JPanel(new GridLayout(height,width));
        mainPanel.add(gamePanel,c);
        
        passMove = new JButton("Pass");
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(passMove,c);
        passMove.setVisible(false);
        
        GUIHandler handler = new GUIHandler();
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                panels[x][y] = new JPanel();
                panels[x][y].setPreferredSize(new Dimension(70,70));
                panels[x][y].setBorder(BorderFactory.createLineBorder(Color.black));
                labels[x][y] = new JLabel();
                panels[x][y].addMouseListener(handler);
                gamePanel.add(panels[x][y]);
            }
        }
        passMove.addActionListener(handler);
        
        frame.add(mainPanel);
        //frame.setLocationRelativeTo(null);
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void drawPieces() {
        for (int y  = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                GamePiece p = board.getPiece(x,y);
                
                if (p != null) {
                    labels[x][y].setIcon(p.getIcon());
                }
                panels[x][y].add(labels[x][y]);
            }
        }
        //System.out.println("pieces drawn");
        SwingUtilities.updateComponentTreeUI(frame);    
    }
    
    public GameController getGame() {
        return game;
    }
    
    public BoardGame getBoard() {
        return board;
    }
    
    public JPanel[][] getPanels() {
        return panels;
    }
    
    public boolean setPassButton() {
        passMove.setVisible(true);
        frame.pack();
        
        return true;
    }
    
    public void showWinningBox() {
        
        JOptionPane.showMessageDialog(frame,
                game.getPlayerName(board.getWinningColour()) + "   WINS!!!!", "Winner",
                JOptionPane.OK_OPTION, m_icon);
        
       System.exit(0);
    }
    
    private class GUIHandler implements MouseListener, ActionListener {
     // these methods had to be declared as MouseListener is abstract
        public void mousePressed(MouseEvent e){    }
        public void mouseClicked(MouseEvent e) {    }
        public void mouseEntered(MouseEvent e) {    }
        public void mouseExited(MouseEvent e) {    }
        
        public void mouseReleased(MouseEvent e) {
            boolean moveComplete = false;
            if (game.getGamOn()) {
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; ++x) {
                        if (e.getSource() == panels[x][y]) {
                            //System.out.println("Clicked: panels[" + x + "][" + y +"]");
                            moveComplete = board.move(x, y, game.getCurrent());
                        }
                    }
                }
                if (moveComplete) {
                    game.alternate();
                    drawPieces();
                    if (game.checkWin()) {
                        //setWinnerLabel();
                        showWinningBox();
                    }
                    System.out.println(board.toString());
                }
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (game.getGamOn()) {
                if (((Othello) board).checkPassTurn()) {
                    game.alternate();
                }
                System.out.println(game.getCurrent());
            }
            
        }
    }
}
