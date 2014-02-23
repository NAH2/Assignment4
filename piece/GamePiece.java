package piece;

import javax.swing.*;

public abstract class GamePiece {
    
    public GamePiece() {
        ++m_totalPieces;
    }
    
    public static int getTotalPieces() {
        return m_totalPieces;
    }
    
    public void setColour(String col) {
        m_colour = col;
        //System.out.println("colour changed");
    }
    
    public String getColour() {
        return m_colour;
    }
    
    public abstract Icon getIcon();
    
    public abstract void setIcons();
    
    //variable declarations
    private static int m_totalPieces;
    private String m_colour;
}