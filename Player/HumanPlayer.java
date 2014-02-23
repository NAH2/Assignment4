/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author So
 */
import java.awt.*;
import java.awt.event.MouseEvent;

public class HumanPlayer {

    private String playerName;
    private boolean playerTurn;
    private int pieceColor;

    public HumanPlayer(String playName, boolean playerTurn, int pieceColor) {
        this.playerName = playName;
        this.playerTurn = playerTurn;
        this.pieceColor = pieceColor;
    }

    public String GetPlayerName() {
        return this.playerName;
    }

    public void SetPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean GetPlayerTurn() {
        return this.playerTurn;
    }

    public void SetPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int GetColor() {
        return this.pieceColor;
    }

    public void SetPieceColor(int color) {
        this.pieceColor = color;
    }

    public void setPlayer(String playerType) {
    }

    public void setPlayerText(String name) {
    }

    public void placePiece(int[][] inCoord) {

        if (validMove(inCoord) == true) {

        }

    }

    public boolean validMove(int[][] inCoord) {
        boolean bool = false;
        return bool;
    }

    public int[][] mouseReleased(MouseEvent e) {
        int[][] position = null;
        return position;
    }

    public int[][] lastPiecePlaced() {
        int[][] position = null;
        return position;
    }

    public void updateLastPiece(int[][] coord) {
    }
}
