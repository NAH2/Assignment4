import Player.*;
import boardGame.*;

//this is rough as hell, no where near finished
public class GameController {
    String connectFour = "connectFour";
    String othello = "othello";
    String red = "red";
    String yellow = "yellow";
    String white = "white";
    String black = "black";
    String current = "black";
    Connect4GUI c4GUI;
    OthelloGUI othelloGUI;
    String gameType;
    
    HumanPlayer p1;
    HumanPlayer p2;
    HumanPlayer currentPlayer;
    
    public static void main(String[] args) {
        GameController a = new GameController("othello");
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
            Othello board = new Othello();
            othelloGUI = new OthelloGUI(board, this);
            othelloGUI.drawPieces();
            othelloGUI.setPanelColour();
        } else if (gameType.equals(connectFour)) {
            ConnectFour board = new ConnectFour();
            c4GUI = new Connect4GUI(board, this);
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
    
    public String getCurrent() {
        return currentPlayer.GetPiece();
    }
    
}