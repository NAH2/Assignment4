package boardGame;

import piece.*;

public abstract class BoardGame {
    protected GamePiece[][] board;
    private final int width;
    private final int height;
    private String winningColour;
    
    
    public BoardGame(int x, int y) {
        width = x;
        height = y;
        board = new GamePiece[width][height];
    }
    
    public int GetWidth() {
        return width;
    }
    
    public int GetHeight() {
        return height;
    }
    
    public GamePiece GetPiece(int x, int y) {
        if  (board[x][y] != null) {
            return board[x][y];
        } else {
            return null;
        }
    }
    
    public int GetTotalPieces() {
        int count = 0;
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                if (board[x][y] != null) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean SetWinningColour(String winner) {
        winningColour = winner;
        return true;
    }
    
    public String GetWinningColour() {
        return winningColour;
    }
    public abstract boolean SetPiece(int x, int y, String col);
    public abstract boolean Move(int x, int y, String col);
    public abstract boolean WinningCondition();
    public abstract boolean SetWinner();
    
    @Override
    public String toString() {
        String boardStateString = "";
        String newline = System.getProperty("line.separator");
        
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                if (board[x][y] != null) {
                    boardStateString += "[" + board[x][y].GetColour() + "] ";
                } else {
                    boardStateString += "[" + null + "] "; 
                }
                
                if (x == width-1) {
                    boardStateString += newline;
                }
            }
        }
        return boardStateString;
    }
}