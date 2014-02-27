/**
 * @file   -OthelloPiece.java
 * @author -Gavin Bailey 711036
 * @date   -24th Feb 14
 * 
 * /brief Othello game piece used in a game of Othello,
 * extends GamePiece.java
 * 
 * This is an extension of the GamePiece class, where the icons
 * differ from other piece types.
 */
package piece;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class OthelloPiece extends GamePiece{
    
    /**
     * Constructor of OthelloPiece, calls  setColour() and setIcons()
     * @param col a String to set colour using setColour() of the superclass
     */
    public OthelloPiece(String col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: OthelloPiece() BEGIN");
        }
        
        SetColour(col);
        SetIcons();
        
        if (test || m_test) {
            System.out.println("OthelloPiece :: OthelloPiece() END");
        }
    }
    
    /**
     * Accessor method to retrieve the ImageIcon of the piece
     * @return Icon depending on piece colour
     */
    public Icon GetIcon() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: getIcon() BEGIN");
        }
        
        if (GetColour().equals("black")) {
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
    
    /**
     * Accessor method to set the ImageIcons of a piece
     * @return boolean on success
     * @throws NullPointerException
     */
    public boolean SetIcons()  throws NullPointerException {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: setIcons() BEGIN");
        }
        
        String blackImageURL = "black.png";
        String whiteImageURL = "white.png";
        
        try {
            m_blackpiece = new ImageIcon(getClass().getResource(blackImageURL));
            m_whitepiece = new ImageIcon(getClass().getResource(whiteImageURL));
        } catch (NullPointerException e) {
            System.out.println("Images Not Found");
        }
        
        if (test || m_test) {
            System.out.println("OthelloPiece :: setIcons() END");
        }
        
        return true;
    }
    
    //variable declarations
    /** store the black icon */
    private Icon m_blackpiece;
    /** store the white icon */
    private Icon m_whitepiece;
    /** Indicates whether to run tests */
    private boolean m_test = false;
}