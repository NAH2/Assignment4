/*/**
 * @file    -GameBoard.java
 * @author  -Chun Kit So
 * @date    -21 Feb '2014
 *
 *  \brief Create a gameboard
 *
 *
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.IOException;

public class GameBoard extends javax.swing.JFrame {

    int[][] gameBoard;
    boolean playerTurn;
    private int empty = 0, black = 1, white = 2, boardSizeX, boardSizeY;
    Othello othelloGame;
    Icon blackpiece = new ImageIcon(getClass().getResource("black.png"));
    Icon whitepiece = new ImageIcon(getClass().getResource("white.png"));
    private JPanel[][] squareBoard;

    /**
     * Creates new form GameBoard
     */
    public GameBoard() {
        initComponents();
    }

    public int[][] getGameboard() {
        return this.gameBoard;
    }

    public void setGameboard(int[][] gameboard) {
        this.gameBoard = gameboard;
    }

    public GameBoard(boolean game) throws IOException {     //true = othello , false = connect4 
        initComponents();

        if (game == true) {
			othelloGame = new Othello();
            boardSizeY = 8;
            boardSizeX = 8;
            squareBoard = new JPanel[boardSizeY][boardSizeX];
            gameBoard = new int[boardSizeY][boardSizeX];
            for (int i = 0; i < boardSizeY; i++) {    //use for loop to make a 8*8 game board 
                for (int j = 0; j < boardSizeX; j++) {
                    Border blackBorder = BorderFactory.createLineBorder(Color.black);
                    final JPanel square = new JPanel();   // assign a Jpanel in each square
                    squareBoard[i][j] = square;
                    square.setBorder(blackBorder);
                    square.setBackground(new Color(170, 150, 100));
                    if ((i == 3 && j == 3) || (i == 4 && j == 4)) {       // initial the game board, start with 2 black pieces and 2 white piece
                        square.add(new JLabel(blackpiece));
                        gameBoard[i][j] = black;
                    } else if ((i == 4 && j == 3) || (i == 3 && j == 4)) {
                        square.add(new JLabel(whitepiece));
                        gameBoard[i][j] = white;
                        /*} else if((i == 2 && j == 2)||(i == 5 && j == 1)||(i == 6 && j ==3)||(i == 6 && j == 6)||(i == 4 && j == 6)||(i == 5 && j == 3)||(i == 3 && j == 5)){
                         square.add(new JLabel(whitepiece));
                         gameBoard[i][j] = white;*/
                    } else {
                        gameBoard[i][j] = empty;
                    }

                    gamePanel.add(square);
                    final int row = i;
                    final int col = j;
                    square.addMouseListener(new MouseAdapter() {     //Add moseRelease event in each Jpanel
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            System.out.println("Position :" + col + "," + row);
                            othelloGame.Move(row, col, gameBoard, true);  // do move action 
                            try {
                                Update(gameBoard);   // update whole game board
                            } catch (IOException e3) {
                            }
                            //}
                            // check vaild move here ! 
                        }
                    });
                }

            }
            char[][] availableMov = othelloGame.AvailableMove(gameBoard, true); // show the available move ,when the game start
            for (int i = 0; i < boardSizeY; i++) {
                for (int j = 0; j < boardSizeX; j++) {
                    if (availableMov[i][j] == 'O') {
                        if (othelloGame.GetPlayerTurn()) {
                            squareBoard[i][j].setBackground(new Color(255, 0, 0));
                        } else {
                            squareBoard[i][j].setBackground(new Color(0, 0, 255));
                        }
                    }
                }
            }
        } else {
            System.out.println("Connect4");
        }

    }

    private void Update(int[][] gameBoard) throws IOException {
        for (int i = 0; i < boardSizeY; i++) {
            for (int j = 0; j < boardSizeX; j++) {
                if (gameBoard[i][j] == black) {  //add the pieces into game board
                    squareBoard[i][j].removeAll();
                    squareBoard[i][j].add(new JLabel(blackpiece));
                    squareBoard[i][j].updateUI();
                    //System.out.println(gameBoard[i][j]);
                } else if (gameBoard[i][j] == white) {
                    squareBoard[i][j].removeAll();
                    squareBoard[i][j].add(new JLabel(whitepiece));
                    squareBoard[i][j].updateUI();
                }
            }
        }

        char[][] availableMov = othelloGame.AvailableMove(gameBoard, true);  // check the available move again when the piece is placed.
        for (int i = 0; i < boardSizeY; i++) {
            for (int j = 0; j < boardSizeX; j++) {
                squareBoard[i][j].setBackground(new Color(170, 150, 100));
                if (availableMov[i][j] == 'O') {
                    if (othelloGame.GetPlayerTurn()) {
                        squareBoard[i][j].setBackground(new Color(255, 0, 0));
                    } else {
                        squareBoard[i][j].setBackground(new Color(0, 0, 255));
                    }
                }
            }
        }
        othelloGame.winningCondition();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        gamePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));

        jPanel1.setLayout(new java.awt.BorderLayout());

        gamePanel.setBackground(new java.awt.Color(204, 204, 255));
        gamePanel.setPreferredSize(new java.awt.Dimension(800, 800));
        gamePanel.setRequestFocusEnabled(false);
        gamePanel.setLayout(new java.awt.GridLayout(8, 8));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GameBoard(true).setVisible(true);
                } catch (IOException e2) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
