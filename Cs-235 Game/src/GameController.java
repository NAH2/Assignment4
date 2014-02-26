import Player.*;
import boardGame.*;

//this is rough as hell, no where near finished
public class GameController {
    private final String connectFour = "connectFour";
    private final String othello = "othello";
    private Connect4GUI c4GUI;
    private OthelloGUI othelloGUI;
    private Othello othelloBoard;
    private ConnectFour connectFourBoard;
    private String gameType;
    boolean gameOn = true;
    
    private HumanPlayer p1;
    private HumanPlayer p2;
    private HumanPlayer currentPlayer;
    
    public static void main(String[] args) {
        GameController a = new GameController("connectFour");
        //GameController b = new GameController("othello");
    }
    
    
    
    public GameController(String gt, HumanPlayer one, HumanPlayer two) {
        p1 = one;
        p2 = two;
        currentPlayer = p1;
        gameType = gt;
        setUp(gameType);
    }
    
    public GameController(String gt) {
        gameType = gt;

        if (gameType.equals(othello)) {
            p1 = new HumanPlayer("Jim", "white");
            p2 = new HumanPlayer("Bob", "black"); 
        } else if (gameType.equals(connectFour)) {
            p1 = new HumanPlayer("Jim", "red");
            p2 = new HumanPlayer("Bob", "yellow"); 
        }
        currentPlayer = p1;
        System.out.println("P1: " + p1.GetPiece());
        System.out.println("P2: " + p2.GetPiece());

        setUp(gameType);
    }
    
    public void setUp(String gameType) {
        System.out.println(getCurrent());
        
        if (gameType.equals(othello)) {
            othelloBoard = new Othello();
            othelloGUI = new OthelloGUI(othelloBoard, this);
            othelloGUI.drawPieces();
            othelloGUI.setPanelColour();
        } else if (gameType.equals(connectFour)) {
            connectFourBoard = new ConnectFour();
            c4GUI = new Connect4GUI(connectFourBoard, this);
            c4GUI.drawPieces();
            c4GUI.setPanelColour();
        }
    }
    
   public void alternate() {
        if (currentPlayer == p1) {
            currentPlayer = p2;
        } else if (currentPlayer == p2) {
            currentPlayer = p1;
        }
        
        if (gameType.equals(othello)) {
            othelloGUI.setPanelColour();
        } else if (gameType.equals(connectFour)) {
            c4GUI.setPanelColour();
        }
    }
    
    public boolean checkWin() {
        boolean win = false;
        if (gameType.equals(othello)) {
            win = othelloBoard.winningCondition();
        } else if (gameType.equals(connectFour)) {
            win = connectFourBoard.winningCondition();
        }
        setGameOn(win);
        return win;
    }
    
    public boolean getGamOn() {
        return gameOn;
    }
    
    public boolean setGameOn(boolean win) {
        if (win) {
            gameOn = false;
        } else {
            gameOn = true;
        }
        return true;
    }
    
    public String getPlayerName(String colour) {
        if (p1.GetPiece().equals(colour)) {
            return p1.GetPlayerName();
        } else {
            return p2.GetPlayerName();
        }
    }

    public String getCurrent() {
        return currentPlayer.GetPiece();
    }
    
}