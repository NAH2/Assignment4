package boardGame;

import piece.*;

public abstract class BoardGame {
    public BoardGame(int x, int y) {
	   SetWidth(x);
	   SetHeight(y);
	   board = new GamePiece[m_width][m_height];
	}

	public boolean SetHeight(int y){
		m_height= y;
		return true;
	}

	public int GetHeight() {
	    return m_height;
	}

	public GamePiece GetPiece(int x, int y) {
	    if  (board[x][y] != null) {
	        return board[x][y];
	    } else {
	        return null;
	    }
	}

	public abstract boolean SetPiece(int x, int y, String col);

	public int GetTotalPieces() {
	    int count = 0;
	    for (int y = 0; y < m_height; ++y) {
	        for (int x = 0; x < m_width; ++x) {
	            if (board[x][y] != null) {
	                count++;
	            }
	        }
	    }
	    return count;
	}

	public boolean SetWidth(int x){
		m_width = x;
		return true;
	}

	public int GetWidth() {
	    return m_width;
	}

	public boolean SetWinningColour(String winner) {
	    m_winningColour = winner;
	    return true;
	}

	public String GetWinningColour() {
	    return m_winningColour;
	}

	public abstract boolean SetWinner();

	public abstract boolean Move(int x, int y, String col);

	public abstract boolean WinningCondition();

	@Override
	public String toString() {
	    String boardStateString = "";
	    String newline = System.getProperty("line.separator");
	    
	    for (int y = 0; y < m_height; ++y) {
	        for (int x = 0; x < m_width; ++x) {
	            if (board[x][y] != null) {
	                boardStateString += "[" + board[x][y].GetColour() + "] ";
	            } else {
	                boardStateString += "[" + null + "] "; 
	            }
	            
	            if (x == m_width-1) {
	                boardStateString += newline;
	            }
	        }
	    }
	    return boardStateString;
	}

	protected GamePiece[][] board;
    private int m_width;
    private int m_height;
    private String m_winningColour;
}