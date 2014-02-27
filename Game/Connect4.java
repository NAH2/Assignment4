//public class connect4 extends Game {

public class Connect4 {   //upper Case 

    private int[][] gameBoard;
    private int scoreYellow, scoreRed, initialScore = 0, counter, counterRed, counterYellow;
    private boolean playerTurn;
    final private int empty = 0, Red = 1, Yellow = 2;
    final private int boardX = 10, boardY = 7;
    private char[][] AvailableMov;
     //HumanPlayer P1 = new HumanPlayer("P1", false, Red); //add the Player (should do it in selection class)
    //HumanPlayer P2 = new HumanPlayer("P2", true, Yellow);
    private HumanPlayer P1;
    private HumanPlayer P2;
    boolean winning_move;

    public Connect4(HumanPlayer P1, HumanPlayer P2) {
        this.P1 = P1;
        this.P2 = P2;
        System.out.println("Connect4 Game created");
        if (P1.GetPlayerTurn()) {
            if (P1.GetPiece().getColour().equals("red")) {     //update
                System.out.println("Player 1(Red) Turn");
            } else {
                System.out.println("Player 1(Yellow) Turn");
            }
        } else if (P2.GetPlayerTurn()) {
            if (P1.GetPiece().getColour().equals("red")) {    //update
                System.out.println("Player 2(Red) Turn");
            } else {
                System.out.println("Player 2(Yellow) Turn");
            }
        }
    }

    public int GetBoardSizeY() {
        return boardY;

    }

    public int GetBoardSizeX() {
        return boardX;
    }

//    public void Connect4(HumanPlayer P1, HumanPlayer P2) {   // get player
//        if (P1.GetPlayerTurn() == true) {
//            playerTurn = P1.GetPlayerTurn();
//        } else {
//            playerTurn = P2.GetPlayerTurn();
//        }
//        
//    }
    //
    //    public boolean SetPlayer(boolean playerTurn) {
    //        this.playerTurn = playerTurn;
    //    }
    public boolean GetPlayerTurn() {
        return playerTurn = P1.GetPlayerTurn();
    }

    public void SetPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    /*public String GetFirstPlayer() {
     if (playerTurn == true){
     return selection.getplayerName();
     } else {
     return selection.getCPUName();
     }
     }*/
    public int[][] GetNewPiecePosition() {   // no idea why is there
        return null;
    }

    //Check to see players dont try and put a counter in a full column
    public char[][] AvailableMove(int[][] gameBoard, boolean playerTurn) {   // check available move and return the char array.
        // 'O' means available move.
        AvailableMov = new char[boardX][boardY];
        for (int i = 0; i < boardX; i++) {
            int j = 0;
            if (j < boardY) {
                System.out.println("Cannot place piece here!");
            }
        }

        //   CheckPassTurn(gameBoard);
        return AvailableMov;
    }

    public void game(int[][] gameBoard, boolean playerTurn) {   //??

    }
    
    

    public GamePiece[][] Move(int y, int x, int[][] gameBoard, boolean playerTurn) {   //move action
        if (validMove(y, x, gameBoard, playerTurn)) {        // check whether the move is valid or not.
            if (P1.GetPlayerTurn()) {            // check the player turn
               
                if (P2.GetColor() == Red) {
                    System.out.println("Player 2(Red) Turn");
                } else {
                    System.out.println("Player 2(Yellow) Turn");
                }
                return gameBoard;
            } else {
                do {
                    gameBoard = Flip(flipdata, gameBoard);
                } while (validMove(y, x, gameBoard, playerTurn));
                gameBoard[y][x] = P2.GetColor();
                P2.SetPlayerTurn(false);
                P1.SetPlayerTurn(true);
                this.gameBoard = gameBoard;
                System.out.println("Red score:" + GetScoreRed());
                System.out.println("Yellow score:" + GetScoreYellow());
                if (P1.GetColor() == Red) {
                    System.out.println("Player 1(Red) Turn");
                } else {
                    System.out.println("Player 1(Yellow) Turn");
                }
                return gameBoard;
            }

        }

        System.out.println("Non-valid move");
        this.gameBoard = gameBoard;
        return gameBoard;
    }

    public boolean horizontal_win (boolean winning_move) {
        for (int x = 0; x < boardX; x++) {
            for (int y = 0; y < boardY; y++) {
                if(gameBoard[y][x] = P1.GetColor()){
                    
                }
            }

    public boolean vertical_win (boolean winning_move) {
        for (int y = 0; y < boardy; y++) {
            for (int x = 0; x < boardX; x++) {
                if(gameBoard[y][x] = P1.GetColor()){
                
                }
    }

    //checks if any player can make a move
    public boolean grid_Status() {
        boolean gridFull = false;
        for (int x = 0; x < boardX; x++) {
            for (int y = 0; y < boardY; y++) {
                if (AvailableMov[y][x] != 'O') {
                    //  return "gameon";
                    gridFull = true;

                }
            }

        }
        return gridFull;
    }

    //Winning and drawing Conditions
    public boolean winningCondition() {
        if (counterRed() < 4 && counterYellow() < 4 && gridFull == true) {
            System.out.println("draw");
        } else if ((counterYellow() == 4 && P1.GetColor() == Yellow) || (counterRed() == 4 && P1.GetColor() == Red)) {
            System.out.println("Player 1 wins");
        } else {
            System.out.println("Player 2 wins");
        }
        return true;

    }

}
}
