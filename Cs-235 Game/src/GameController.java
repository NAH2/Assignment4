

import boardGame.*;

//this is rough as hell, no where near finished
public class GameController {
    String red = "red";
    String yellow = "yellow";
    String white = "white";
    String black = "black";
    String current = "black";
    Connect4GUI c4GUI;
    OthelloGUI othelloGUI;
    static String gameType = "connectFour";
    
    public static void main(String[] args) {
    	GameController game = new GameController(gameType);
    }
    
    public GameController(String gameType) {
        setUp(gameType);
    }
    
    public void setUp(String gameType) {
        if (gameType.equals("othello")) {
            Othello board = new Othello();
            othelloGUI = new OthelloGUI(board, this);
            othelloGUI.drawPieces();
            othelloGUI.setPanelColour();
            current = "black";
        } else if (gameType.equals("connectFour")) {
            ConnectFour board = new ConnectFour();
            c4GUI = new Connect4GUI(board, this);
            c4GUI.drawPieces();
            c4GUI.setPanelColour();
            current = "red";
        }

        //ConnectFour board = new ConnectFour();
        //gui = new Connect4GUI(board, this);
        //System.out.println("Total Pieces: " + board.getTotalPieces());
        
        //System.out.println("\n" + board.toString());
        //gui.drawPieces();
        //gui.setPanelColour();
        //((Connect4GUI)gui).setPanelColour();
    }
    
   public void alternate() {
        if (current.equals(white)) {
            current = black;
            othelloGUI.setPanelColour();
        } else if (current.equals(black)) {
            current = white;
            othelloGUI.setPanelColour();
        }
        
        if (current.equals(red)) {
            current = yellow;
            c4GUI.setPanelColour();
        } else if (current.equals(yellow)) {
            current = red;
            c4GUI.setPanelColour();
        }
    }
    
    public String getCurrent() {
        return current;
    }
    
}