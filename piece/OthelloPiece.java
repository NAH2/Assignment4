package piece;

import javax.swing.*;

public class OthelloPiece extends GamePiece{
    
    public OthelloPiece(String col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: OthelloPiece() BEGIN");
        }
        
        setColour(col);
        setIcons();
        
        if (test || m_test) {
            System.out.println("OthelloPiece :: OthelloPiece() END");
        }
    }
    
    public Icon getIcon() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: getIcon() BEGIN");
        }
        
        if (getColour().equals("black")) {
            if (test || m_test) {
                System.out.println("OthelloPiece :: getIcon() END");
            }
            
            return m_blackpiece;
        } else {
            if (test || m_test) {
                System.out.println("OthelloPiece :: getIcon() END");
            }
            
            return m_whitepiece;
        }
    }
    
    public boolean setIcons() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: setIcons() BEGIN");
        }
        
        try {
            m_blackpiece = new ImageIcon(getClass().getResource("black.png"));
            m_whitepiece = new ImageIcon(getClass().getResource("white.png"));
        } catch (NullPointerException e) {
            System.out.println("Images Not Found");
        }
        
        if (test || m_test) {
            System.out.println("OthelloPiece :: setIcons() END");
        }
        
        return true;
    }
    
    //variable declarations
    private Icon m_blackpiece;
    private Icon m_whitepiece;
    private boolean m_test = false;
}