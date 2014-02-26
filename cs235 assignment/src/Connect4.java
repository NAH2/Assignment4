//public class connect4 extends Game {

public class Connect4 {   //upper Case 

    //  private int[][] gameBoard;
    private int scoreYellow, scoreRed, initialScore = 0, counter, counterRed, counterYellow;
    private boolean playerTurn;
    // final private int empty = 0, Red = 1, Yellow = 2, boardX = 10, boardY=7;
    final private int boardX = 10, boardY = 7;
    private char[][] AvailableMov;
    // HumanPlayer P1 = new HumanPlayer("P1", false, Red); //add the Player (should do it in selection class)
    //HumanPlayer P2 = new HumanPlayer("P2", true, Yellow);
    private HumanPlayer P1;
    private HumanPlayer P2;

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
                do {
                    gameBoard = Flip(flipdata, gameBoard);             //do the flip action here
                } while (validMove(y, x, gameBoard, playerTurn));     // while it is valid move
                gameBoard[y][x] = P1.GetColor();         // add the piece into gameBoard
                P1.SetPlayerTurn(false);
                P2.SetPlayerTurn(true);
                this.gameBoard = gameBoard;  // get gameboard array from gameBoard.
                System.out.println("Red score:" + GetScoreRed());
                System.out.println("Yellow score:" + GetScoreYellow());
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

    //  (connect4 CORE)    edited to basically do the same thing but to count the number of red/yellow counters in a sequence.
    private boolean playerScoreCounter(int y, int x, GamePiece[][] gameBoard, boolean playerturn) {

        // if (gameBoard[y][x] == 0) {
        if (gameBoard[y][x] == null) {
            int searchX, searchY;
            //int searchValue, playerColor, Y;
            GamePiece searchValue, playerColor;

            if (P1.GetPlayerTurn() == true) {
                playerColor = P1.GetPiece();
            } else {
                playerColor = P2.GetPiece();
            }
            counter = 1;

            // Search each direction (total = 5 direction)
            for (int i = 0; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    boolean found = false;
                    searchY = y + i;
                    searchX = x + j;

                    //states that the search cannot be outside the parameter of the board!!
                    if ((searchX >= boardX || searchX < 0) || (searchY >= boardY || searchY < 0)) {
                        //System.out.println("Over bound! Y:" + searchY + " X: " + searchX + " i:" + i + " j: " + j);
                        //Debug message
                        continue;

                    } else {
                        searchValue = gameBoard[searchY][searchX];
                    }
                    // skip the search if i and j is 0.
                    // skip the search if one of the direction is empty
                    // skip the search if one of the direction is same color piece (REMOVED)
                    if ((i == 0 && j == 0) || searchValue == null) {
                        continue;
                    }

                    //Searching along the direction
                    while (!found) {
                        //System.out.println("Looping..");
                        //Debug message
                        searchX += j;
                        searchY += i;

                        //prevent out of bound, if x over 10 and y over 7 , exit the while loop and stop searching this direction
                        if ((searchX >= boardX || searchX < 0) || (searchY >= boardY || searchY < 0)) {
                            found = true;
                            
                        } else {
                            searchValue = gameBoard[searchY][searchX];
                        }

                        // if find the same color is along to direction
                        if (searchValue == playerColor) {
                            found = true;
                            counterRed++;
                            return true;
                            //  continue;  it should be keep going , rather than skip this direction

                        } //                        if (searchValue == 2) {
                        //                            found = true;
                        //                            counterYellow++;
                        //                            return true;
                        //                            continue;
                        // } If end of the direction is empty , then stop search this direction.
                        else if (searchValue == null) {
                            found = true;
                            //System.out.println("empty : true, Y:" + searchY + ", X:" + searchX);
                            //Debug message
                        }
                    }
                }

            }

            return false;
        }
        return false;

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
