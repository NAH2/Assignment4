


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

    public GUI(BoardGame b, GameController g) {
        board = b;
        game = g;
        width = board.getWidth();
        height = board.getHeight();
        panels = new JPanel[width][height];
        labels = new JLabel[width][height];
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
        
        JButton passMove = new JButton("Pass");
        c.gridx = 2;
        c.gridy = 2;
        
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
        
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        
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
    
    private class GUIHandler implements MouseListener {
     // these methods had to be declared as MouseListener is abstract
        public void mousePressed(MouseEvent e){    }
        public void mouseReleased(MouseEvent e) {    }
        public void mouseEntered(MouseEvent e) {    }
        public void mouseExited(MouseEvent e) {    }
        
        public void mouseClicked(MouseEvent e) {
            boolean moveComplete = false;
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
                System.out.println(board.toString());
            }
        }
    }
}
