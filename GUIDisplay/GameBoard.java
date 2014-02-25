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

    private GamePiece[][] gameBoard;
    boolean playerTurn;
    //private int empty = 0, black = 1, white = 2, 
    private int boardSizeX, boardSizeY;
    private Othello othelloGame;
    private int scoreWhite, scoreBlack, initialScore = 0;
    Icon emptySpace = new ImageIcon(getClass().getResource("empty.png"));
    private JPanel[][] squareBoard;
    private HumanPlayer P1;
    private HumanPlayer P2;
	Font f = new Font("Dialog", Font.PLAIN, 18);
	private Boolean initialP1Turn;

    public GameBoard(String game, HumanPlayer P1, HumanPlayer P2) throws IOException {
        initComponents();
        this.P1 = P1;
        this.P2 = P2;

        if (game.equals("Othello")) {
            drawOthello();
        } else {
            drawConnect4();
        }

    }

    private void drawOthello() {
	        othelloGame = new Othello(P1, P2);
	        boardSizeY = othelloGame.GetBoardSizeY();
	        boardSizeX = othelloGame.GetBoardSizeX();
	        gamePanel.setPreferredSize(new Dimension(800, 800)); // Hard Code 
	        gamePanel.setLayout(new GridLayout(boardSizeY, boardSizeX));
			initialP1Turn = P1.GetPlayerTurn();
			
        squareBoard = new JPanel[boardSizeY][boardSizeX];
        gameBoard = new OthelloPiece[boardSizeY][boardSizeX];
        for (int i = 0; i < boardSizeY; i++) {    //use for loop to make a 8*8 game board 
            for (int j = 0; j < boardSizeX; j++) {
                Border blackBorder = BorderFactory.createLineBorder(Color.black);
                final JPanel square = new JPanel();   // assign a Jpanel in each square
                squareBoard[i][j] = square;
                square.setBorder(blackBorder);
                square.setBackground(new Color(170, 150, 100));
                if ((i == 3 && j == 3) || (i == 4 && j == 4)) {       // initial the game board, start with 2 black pieces and 2 white piece
                    square.add(new JLabel(P2.GetPiece().getIcon()));
                    gameBoard[i][j] = P2.GetPiece();
                } else if ((i == 4 && j == 3) || (i == 3 && j == 4)) {
                    square.add(new JLabel(P1.GetPiece().getIcon()));
                    gameBoard[i][j] = P1.GetPiece();
                    /*} else if((i == 2 && j == 2)||(i == 5 && j == 1)||(i == 6 && j ==3)||(i == 6 && j == 6)||(i == 4 && j == 6)||(i == 5 && j == 3)||(i == 3 && j == 5)){
                     square.add(new JLabel(playerOnePiece));
                     gameBoard[i][j] = white;*/
                } else {
                    gameBoard[i][j] = null;
                }

                gamePanel.add(square);
                final int row = i;
                final int col = j;
                square.addMouseListener(new MouseAdapter() {     //Add moseRelease event in each Jpanel
                    @Override
                    public void mouseReleased(MouseEvent e) {
                       // System.out.println("Position :" + col + "," + row);
                        othelloGame.Move(row, col, gameBoard);  // do move action 
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
        char[][] availableMov = othelloGame.AvailableMove(gameBoard); // show the available move ,when the game start
        for (int i = 0; i < boardSizeY; i++) {
            for (int j = 0; j < boardSizeX; j++) {
                if (availableMov[i][j] == 'O') {
                    if (P1.GetPlayerTurn() == true) {
                        squareBoard[i][j].setBackground(new Color(255, 0, 0));
                    } else {
                        squareBoard[i][j].setBackground(new Color(0, 0, 255));
                    }
                }
            }
        }
        SetScore();
			playerOneColor.setFont(f);
			playerTwoColor.setFont(f);
			playerOneIcon.setFont(f);
			playerTwoIcon.setFont(f);
			playerTurnIcon.setFont(f);
			playerTurnLabel.setFont(f);
			blackIcon.setFont(f);
			whiteIcon.setFont(f);
			blackPieces.setFont(f);
			whitePieces.setFont(f);
            playerOneColor.setText(P1.GetPlayerName()+"'s color: ");
            playerOneIcon.setIcon(P1.GetPiece().getIcon());
            playerTwoColor.setText(P2.GetPlayerName()+"'s color: ");
			playerTwoIcon.setIcon(P2.GetPiece().getIcon());
            if(P1.GetPlayerTurn() == true) {
			playerTurnIcon.setIcon(P1.GetPiece().getIcon());
		} else {
			playerTurnIcon.setIcon(P2.GetPiece().getIcon());
		}
			playerTurnLabel.setText("Player Turn");
			if(P1.GetPiece().getColour().equals("black")){
				blackIcon.setIcon(P1.GetPiece().getIcon());
				whiteIcon.setIcon(P2.GetPiece().getIcon());
			} else {
				blackIcon.setIcon(P2.GetPiece().getIcon());
				whiteIcon.setIcon(P1.GetPiece().getIcon());
			}
			blackPieces.setText(GetScoreBlack()+"");
			whitePieces.setText(GetScoreWhite()+"");
        //System.out.println("Black score:" + GetScoreBlack());
        //System.out.println("White score:" + GetScoreWhite());
    }

    private void drawConnect4() {
        boardSizeY = 7;     // Hard code 
        boardSizeX = 10;       // Hard code 
        gamePanel.setPreferredSize(new Dimension(1000, 700)); // Hard Code 
        gamePanel.setLayout(new GridLayout(boardSizeY, boardSizeX));
        
        squareBoard = new JPanel[boardSizeY][boardSizeX];
        gameBoard = new ConnectFourPiece[boardSizeY][boardSizeX];
        for (int i = 0; i < boardSizeY; i++) {    //use for loop to make a 8*8 game board 
            for (int j = 0; j < boardSizeX; j++) {
                final JPanel square = new JPanel();   // assign a Jpanel in each square
                squareBoard[i][j] = square;
                Border blackBorder = BorderFactory.createLineBorder(Color.black);
                square.setBackground(new Color(0, 0, 255));
                square.setBorder(blackBorder);
                gamePanel.add(square);
                square.add(new JLabel(emptySpace));
                final int row = i;
                final int col = j;
                square.addMouseListener(new MouseAdapter() {     //Add moseRelease event in each Jpanel
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        System.out.println("Position :" + col + "," + row);
                          // Do something here ! 
                    }
                });

            }
        }
    }

    private void Update(GamePiece[][] gameBoard) throws IOException {
        for (int i = 0; i < boardSizeY; i++) {
            for (int j = 0; j < boardSizeX; j++) {
                if (gameBoard[i][j] == P2.GetPiece()) {  //add the pieces into game board
                    squareBoard[i][j].removeAll();
                    squareBoard[i][j].add(new JLabel(P2.GetPiece().getIcon()));
                    squareBoard[i][j].updateUI();
                    //System.out.println(gameBoard[i][j]);
                } else if (gameBoard[i][j] == P1.GetPiece()) {
                    squareBoard[i][j].removeAll();
                    squareBoard[i][j].add(new JLabel(P1.GetPiece().getIcon()));
                    squareBoard[i][j].updateUI();
                } else if (gameBoard[i][j] == null) {
                    squareBoard[i][j].removeAll();
                    squareBoard[i][j].updateUI();
				}
            }
        }

        char[][] availableMov = othelloGame.AvailableMove(gameBoard);  // check the available move again when the piece is placed.
        for (int i = 0; i < boardSizeY; i++) {
            for (int j = 0; j < boardSizeX; j++) {
                squareBoard[i][j].setBackground(new Color(170, 150, 100));
                if (availableMov[i][j] == 'O') {
                    if (P1.GetPlayerTurn()) {
                        squareBoard[i][j].setBackground(new Color(255, 0, 0));
                    } else {
                        squareBoard[i][j].setBackground(new Color(0, 0, 255));
                    }
                }
            }
        }
        SetScore();
		blackPieces.setText(GetScoreBlack()+"");
		whitePieces.setText(GetScoreWhite()+"");
       // System.out.println("Black score:" + GetScoreBlack());
       // System.out.println("White score:" + GetScoreWhite());
        if(othelloGame.winningCondition()==false){
	        if(P1.GetPlayerTurn()) {
				playerTurnIcon.setIcon(P1.GetPiece().getIcon());
			} else {
				playerTurnIcon.setIcon(P2.GetPiece().getIcon());
			}
		}
    }

    private void SetScore() {
        scoreWhite = initialScore;
        scoreBlack = initialScore;
        for (int x = 0; x < boardSizeX; x++) {
            for (int y = 0; y < boardSizeY; y++) {
                if (gameBoard[y][x] != null) {
                    if (gameBoard[y][x].getColour().equals("white")) {
                        scoreWhite++;
                    } else if (gameBoard[y][x].getColour().equals("black")) {
                        scoreBlack++;
                    }
                }
            }
        }
        othelloGame.SetScoreWhite(scoreWhite);
        othelloGame.SetScoreBlack(scoreBlack);
    }

    private int GetScoreBlack() {
        return scoreBlack;
    }

    private int GetScoreWhite() {
        return scoreWhite;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        restart = new javax.swing.JButton();
        TextPanel2 = new javax.swing.JPanel();
        playerOneColor = new javax.swing.JLabel();
        playerOneIcon = new javax.swing.JLabel();
        playerTwoColor = new javax.swing.JLabel();
        playerTwoIcon = new javax.swing.JLabel();
        playerTurnIcon = new javax.swing.JLabel();
        playerTurnLabel = new javax.swing.JLabel();
        blackIcon = new javax.swing.JLabel();
        blackPieces = new javax.swing.JLabel();
        whiteIcon = new javax.swing.JLabel();
        whitePieces = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));

        gamePanel.setBackground(new java.awt.Color(204, 204, 255));
        gamePanel.setPreferredSize(new java.awt.Dimension(800, 800));
        gamePanel.setRequestFocusEnabled(false);
        gamePanel.setLayout(new java.awt.BorderLayout());

        restart.setText("RESTART");
        restart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                restartMouseReleased(evt);
            }
        });

        TextPanel2.setLayout(new java.awt.GridLayout(5, 2));
        TextPanel2.add(playerOneColor);
        TextPanel2.add(playerOneIcon);
        TextPanel2.add(playerTwoColor);
        TextPanel2.add(playerTwoIcon);
        TextPanel2.add(playerTurnIcon);
        TextPanel2.add(playerTurnLabel);
        TextPanel2.add(blackIcon);
        TextPanel2.add(blackPieces);
        TextPanel2.add(whiteIcon);
        TextPanel2.add(whitePieces);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(restart)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(TextPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(restart)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>                        

    private void restartMouseReleased(java.awt.event.MouseEvent evt) {    
		if(initialP1Turn == true) {                                 
        	P1.SetPlayerTurn(true);
			P2.SetPlayerTurn(false);
		} else {
			P1.SetPlayerTurn(false);
			P2.SetPlayerTurn(true);
		}
		scoreWhite = initialScore;
		scoreBlack = initialScore;
		
        for (int i = 0; i < boardSizeY; i++) {    //use for loop to make a 8*8 game board 
            for (int j = 0; j < boardSizeX; j++) {
	                if ((i == 3 && j == 3) || (i == 4 && j == 4)) {       // initial the game board, start with 2 black pieces and 2 white piece
	                    gameBoard[i][j] = P2.GetPiece();
	                } else if ((i == 4 && j == 3) || (i == 3 && j == 4)) {
	                    gameBoard[i][j] = P1.GetPiece();
					} else {
						gameBoard[i][j] = null;
					}	
			}
    	}
		try{
			Update(gameBoard);
		} catch (IOException e4) {}        // TODO add your handling code here:
    }                                     

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
      //  java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new GameBoard("Connect4").setVisible(true);
//                } catch (IOException e2) {
//                }
//            }
      //  });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel TextPanel2;
    private javax.swing.JLabel blackIcon;
    private javax.swing.JLabel blackPieces;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel playerOneColor;
    private javax.swing.JLabel playerOneIcon;
    private javax.swing.JLabel playerTurnIcon;
    private javax.swing.JLabel playerTurnLabel;
    private javax.swing.JLabel playerTwoColor;
    private javax.swing.JLabel playerTwoIcon;
    private javax.swing.JButton restart;
    private javax.swing.JLabel whiteIcon;
    private javax.swing.JLabel whitePieces;
    // End of variables declaration                   
}


