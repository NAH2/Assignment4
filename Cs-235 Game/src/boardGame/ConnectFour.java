package boardGame;

import piece.*;

public class ConnectFour extends BoardGame {
    String yellow = "yellow";
	String red = "red";
	int w=10;
	int h=7;
    public ConnectFour() {
        super(10, 7);
    }
    
    public boolean setPiece(int x, int y, String col) {
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
            horizontal_winner();

            return true;
        } else {
            System.out.println("Space Occupied");
            return false;
        }
	 
        //System.out.println("Total Pieces: " + getTotalPieces());
    }

	//8 methods for determinding if there are 4 peices connected vertically, horizontally and diagonally 
	
	public boolean horizontal_winner() {
		boolean horizontal_winner_red = false;
		boolean horizontal_winner_yellow = false;
		int redCounter=0; 
		int yellowCounter=0;
		System.out.println("gg");
    	for (int y = 0; y < h; y++) {
        	for (int x = 0; x < w; x++) {
        	    if(board[x][y] != null) {
					if (board[x][y].getColour().equals(yellow)) {
						redCounter=0;
						yellowCounter++;
						System.out.println(yellowCounter);
					} else if (board[x][y].getColour().equals(red)) {
					    yellowCounter=0;
					    redCounter++;
					    System.out.println(redCounter);
					}
				}
    	    }
		}
    	System.out.println(redCounter);
        System.out.println(yellowCounter);

		if (redCounter >= 4) {
			horizontal_winner_red=true;
			System.out.println("red Wins");
			return horizontal_winner_red;
		}
		if (yellowCounter >= 4) {
			horizontal_winner_yellow=true;
			System.out.println("yellow Wins");
			return horizontal_winner_yellow;
		}
		return true;
	}			
	/*
	public boolean horizontal_winner_yellow() {
	        boolean horizontal_winner_yellow = false;
	        	for (int x = 0; x < w; x++) {
	            	for (int y = 0; y < h; y++) {
							if (board[x][y].getColour.equals("yellow") &&
							    board[x+1][y].getColour.equals("yellow") &&
							    board[x+2][y].getColour.equals("yellow") &&
							    board[x+3][y].getColour.equals("yellow")) {
							    System.out.println("yellow  Wins!");
								horizontal_winner_yellow=true;
								}}}
								return horizontal_winner_yellow;
							}
							
	public boolean horizontal_winner_red() {
		        boolean horizontal_winner_red = false;
		        	for (int x = 0; x < w; x++) {
		            	for (int y = 0; y < h; y++) {
								if (board[x][y].equals(red) &&
								    board[x+1][y].equals(red) &&
								    board[x+2][y].equals(red) &&
								    board[x+3][y].equals(red)) {
								   System.out.println("red  Wins!");
									horizontal_winner_red=true;
									}}}
									return horizontal_winner_red;
								}
								
	public boolean vertical_winner_yellow() {
		        boolean vertical_winner_yellow = false;
		        	for (int x = 0; x < w; x++) {
		            	for (int y = 0; y < h; y++) {
								if (board[x][y].equals(yellow) &&
								    board[x][y+1].equals(yellow) &&
								    board[x][y+2].equals(yellow) &&
								    board[x][y+3].equals(yellow)) {
								    System.out.println("yellow  Wins!");
									vertical_winner_yellow=true;
									}}}
									return vertical_winner_yellow;
								}
								
	public boolean vertical_winner_red() {
			        boolean vertical_winner_red = false;
			        	for (int x = 0; x < w; x++) {
			            	for (int y = 0; y < h; y++) {
									if (board[x][y].equals(red) &&
									    board[x][y+1].equals(red) &&
									    board[x][y+2].equals(red) &&
									    board[x][y+3].equals(red)) {
									    System.out.println("red  Wins!");
										vertical_winner_red=true;
										}}}
										return vertical_winner_red;
									}	
										
	public boolean inc_diagonal_winner_yellow() {
			        boolean inc_diagonal_winner_yellow = false;
			        	for (int x = 0; x < w; x++) {
			            	for (int y = 0; y < h; y++) {
									if (board[x][y].equals(yellow) &&
									    board[x+1][y+1].equals(yellow) &&
									    board[x+2][y+2].equals(yellow) &&
									    board[x+3][y+3].equals(yellow)) {
									    System.out.println("yellow  Wins!");
										inc_diagonal_winner_yellow=true;
										}}}
										return inc_diagonal_winner_yellow;
									}
									
	public boolean inc_diagonal_winner_red() {
				        boolean inc_diagonal_winner_red = false;
				        	for (int x = 0; x < w; x++) {
				            	for (int y = 0; y < h; y++) {
										if (board[x][y].equals(red) &&
										    board[x+1][y+1].equals(red) &&
										    board[x+2][y+2].equals(red) &&
										    board[x+3][y+3].equals(red)) {
										    System.out.println("red  Wins!");
											inc_diagonal_winner_red=true;
											}}} 
											return inc_diagonal_winner_red;
										}
										
	public boolean dec_diagonal_winner_yellow() {
				        boolean dec_diagonal_winner_yellow = false;
				        	for (int x = 0; x < w; x++) {
				            	for (int y = 0; y < h; y++) {
										if (board[x][y].equals(yellow) &&
										    board[x-1][y-1].equals(yellow) &&
										    board[x-2][y-2].equals(yellow) &&
										    board[x-3][y-3].equals(yellow)) {
										    System.out.println("yellow  Wins!");
											dec_diagonal_winner_yellow=true;
											}}} 
											return dec_diagonal_winner_yellow;
										}
											
	public boolean dec_diagonal_winner_red() {
					        boolean dec_diagonal_winner_red = false;
					        	for (int x = 0; x < w; x++) {
					            	for (int y = 0; y < h; y++) {
											if (board[x][y].equals(red) &&
											    board[x-1][y-1].equals(red) &&
											    board[x-2][y-2].equals(red) &&
											    board[x-3][y-3].equals(red)) {
											    System.out.println("red  Wins!");
												dec_diagonal_winner_red=true;
												}}}
												 return dec_diagonal_winner_red;
											}	
												*/
    //checks if any player can make a move
    //only need to check top row
    public boolean grid_Status(int w, int h) {
       boolean gridFull = false;
		int j=0;
		
			while (j<w) {
				if (board[j][h] != null){
				j++;	
				}
			}
			
			if (j>=10) {
				gridFull=true;
				System.out.println("grid full");
				return gridFull;
			}
			return false;
	}
	
}
