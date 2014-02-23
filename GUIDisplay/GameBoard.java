
/**
 * @file -GameBoard.java
 * @author -Chun Kit So
 * @date -21 Feb '2014
 *
 * \brief Create a gameboard
 *
 *
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GameBoard extends javax.swing.JFrame {

    private int[][] gameBoard;
    private JPanel[][] squareBoard = new JPanel[8][8];
    private ImageIcon picture;
    boolean playerTurn;
<<<<<<< HEAD
    Image piece;

    private int empty = 0, black = 1, white = 2;
    Othello othelloGame = new Othello();
    Icon blackpiece = new ImageIcon(getClass().getResource("black.png"));
    Icon whitepiece = new ImageIcon(getClass().getResource("white.png"));

=======
    Image piece ;
    private int empty = 0,black = 1, white = 2;
    Othello othelloGame = new Othello();
    Icon blackpiece = new ImageIcon(getClass().getResource("black.png"));
    Icon whitepiece = new ImageIcon(getClass().getResource("white.png"));
>>>>>>> 9e9548589883700d652ab38f27b6c6768860128c
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
<<<<<<< HEAD

    public GameBoard(boolean game) {     //true = othello , false = connect4 
        initComponents();

=======
    
    public GameBoard(boolean game) throws IOException{     //true = othello , false = connect4 
      initComponents();
      
>>>>>>> 9e9548589883700d652ab38f27b6c6768860128c
        if (game = true) {
			//final JPanel square = new JPanel();
            gameBoard = new int[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Border blackBorder = BorderFactory.createLineBorder(Color.black);
                    final JPanel square = new JPanel();
                    square.setBorder(blackBorder);
<<<<<<< HEAD
                    square.setBackground(new Color(170, 150, 100));
                    if ((i == 3 && j == 3) || (i == 4 && j == 4)) {
                        square.add(new JLabel(blackpiece));
                        gameBoard[i][j] = black;
                    } else if ((i == 4 && j == 3) || (i == 3 && j == 4)) {
                        square.add(new JLabel(whitepiece));
                        gameBoard[i][j] = white;
                    } else {
                        gameBoard[i][j] = empty;
                    }

                    gamePanel.add(square);
                    squareBoard[i][j] = square;
                    final int row = i;   //y
                    final int col = j;   //x
                    square.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            System.out.println("Position : col:" + col + ", row:" + row);
                            square.setBackground(new Color(170, 150, 100));
                            othelloGame.Move(row, col, gameBoard, true);
                            Update(square, row, col);

                            // check vaild move here ! 
=======
			        square.setBackground(new Color(170, 150, 100));
					if((i == 3 && j == 3)||(i == 4 && j == 4)){
						square.add(new JLabel(blackpiece));
						gameBoard[i][j] = black;
					} else if((i == 4 && j == 3)||(i == 3 && j == 4)){
						square.add(new JLabel(whitepiece));
						gameBoard[i][j] = white;
					} else if((i == 5 && j == 3)||(i == 3 && j == 5)){
						square.add(new JLabel(whitepiece));
						gameBoard[i][j] = white;
					} else if((i == 6 && j == 6)||(i == 4 && j == 6)){
						square.add(new JLabel(whitepiece));
						gameBoard[i][j] = white;
					} else if((i == 2 && j == 2)||(i == 5 && j == 1)){
						square.add(new JLabel(whitepiece));
						gameBoard[i][j] = white;
					} else {
						gameBoard[i][j] = empty;
					}
                    gamePanel.add(square);
                    final int row = i;
                    final int col = j;
                    square.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            System.out.println("Position :" + col +","+ row );
							//if(othelloGame.ValidMove(row, col, gameBoard)){
                           othelloGame.Move(row, col, gameBoard, true);
							try{
                            	Update(square, row, col);
							} catch(IOException e3){}
							//}
                         // check vaild move here ! 
>>>>>>> 9e9548589883700d652ab38f27b6c6768860128c
                        }
                    });
                }

            }
<<<<<<< HEAD
            char[][] availableMov = othelloGame.availableMove(gameBoard, true);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (availableMov[i][j] == 'O'){
                        squareBoard[i][j].setBackground(new Color(255, 0, 0));
                    }
                }
            }

        }

    }

    public void Update(JPanel square, int y, int x) {

        if (gameBoard[y][x] == black) {
            square.removeAll();
            square.add(new JLabel(new ImageIcon(getClass().getResource("black.png"))));
            square.updateUI();
            System.out.println(gameBoard[x][y]);
        } else if (gameBoard[y][x] == white) {
            square.removeAll();
            square.add(new JLabel(new ImageIcon(getClass().getResource("white.png"))));
            square.updateUI();
        }

=======
        }

    }
    
    public void Update(JPanel square, int row, int col) throws IOException{
        if (gameBoard[row][col] == black){
           //square.setBackground(new Color(0, 0, 0));
            square.removeAll();
            square.add(new JLabel(blackpiece));
			square.updateUI();
               //System.out.println(gameBoard[i][j]);
        }
        else if (gameBoard[row][col] == white){
			square.removeAll();
			square.add(new JLabel(whitepiece));
			square.updateUI();
        }
>>>>>>> 9e9548589883700d652ab38f27b6c6768860128c
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
				} catch (IOException e2) {}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}