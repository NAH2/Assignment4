package piece;

import javax.swing.*;

public class OthelloPiece extends GamePiece{
    
    public OthelloPiece(String col) {
        setColour(col);
        setIcons();
    }
    
    public Icon getIcon() {
        if (getColour().equals("black")) {
            return m_blackpiece;
        } else {
            return m_whitepiece;
        }
    }
    
    public void setIcons() {
        try {
            m_blackpiece = new ImageIcon(getClass().getResource("black.png"));
            m_whitepiece = new ImageIcon(getClass().getResource("white.png"));
        } catch (NullPointerException e) {
            System.out.println("Images Not Found");
        }
    }
    
    //variable declarations
    private Icon m_blackpiece;
    private Icon m_whitepiece;
}