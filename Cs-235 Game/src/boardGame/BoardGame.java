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
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public GamePiece getPiece(int x, int y) {
        if  (board[x][y] != null) {
            return board[x][y];
        } else {
            return null;
        }
    }
    
    public int getTotalPieces() {
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
    
    public boolean setWinningColour(String winner) {
        winningColour = winner;
        return true;
    }
    
    public String getWinningColour() {
        return winningColour;
    }
    public abstract boolean setPiece(int x, int y, String col);
    public abstract boolean move(int x, int y, String col);
    public abstract boolean winningCondition();
    public abstract boolean setWinner();
    
    
    public String toString() {
        String boardStateString = "";
        String newline = System.getProperty("line.separator");
        
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                if (board[x][y] != null) {
                    boardStateString += "[" + board[x][y].getColour() + "] ";
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