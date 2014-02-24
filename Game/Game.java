/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author So
 */
public abstract class Game {
    int[][] gameBoard;
    boolean playerTurn;
    
    public void Move(int[][] placePiece, int[][] GameBoard, boolean playerTurn){
        
    }
    
    public boolean setPlayer(boolean playerTurn){
        return true;
    }
public abstract boolean validMove(int x, int y, int[][] gameBoard, boolean playTurn);

public abstract boolean winningCondition(int[][] gameBoard);

public abstract char[][] availableMove(int[][] gameBoard, boolean playerTurn);

public abstract void game(int[][] gameBoard, boolean playerTurn);
    
}
