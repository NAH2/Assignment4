package boardGame;

import piece.*;

public class ConnectFour extends BoardGame {
    
    public ConnectFour() {
        super(10, 7);
    }
    
    public boolean setPiece(int x, int y, String col){
        board[x][y] = new ConnectFourPiece(col);
        return true;
    }
    
    public boolean move(int x, int y, String col) {
        int index = 0;
        if (board[x][0] == null) {
            for (int h = 0; h < getHeight()-1; ++h) {
                if (board[x][h+1] == null) {
                    index = h+1;
                } else if (board[x][h] == null) {
                    index = h;
                }
            }
            //board[x][index] = new ConnectFourPiece(col);
            setPiece(x,index,col);
            return true;
        } else {
            System.out.println("Space Occupied");
            return false;
        }
        //System.out.println("Total Pieces: " + getTotalPieces());
    }
}