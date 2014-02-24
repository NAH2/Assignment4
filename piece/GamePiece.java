package piece;

import javax.swing.*;

public abstract class GamePiece {
    
    public boolean setColour(String col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("GamePiece :: setColour() BEGIN");
        }
        
        m_colour = col;
        
        if (test || m_test) {
            System.out.println("GamePiece :: setColour() END");
        }
        
        return true;
    }
    
    public String getColour() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("GamePiece :: getColour() BEGIN");
        }
        
        if (test || m_test) {
            System.out.println("GamePiece :: getColour() END");
        }
        
        return m_colour;
        
        
    }
    
    public abstract Icon getIcon();
    
    public abstract boolean setIcons();
    
    //variable declarations
    private String m_colour;
    private boolean m_test = false;
}