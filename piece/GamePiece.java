package piece;

import javax.swing.*;

public abstract class GamePiece {
    
    public void setColour(String col) {
        m_colour = col;
    }
    
    public String getColour() {
        return m_colour;
    }
    
    public abstract Icon getIcon();
    
    public abstract void setIcons();
    
    //variable declarations
    private String m_colour;
}