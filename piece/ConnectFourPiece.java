/**
 * @file   -ConnectFourPiece.java
 * @author -Gavin Bailey 711036
 * @date   -24th Feb 14
 * 
 * /brief Connect Four game piece used in a game of Connect Four,
 * extends GamePiece.java
 * 
 * This is an extension of the GamePiece class, where the icons
 * differ from other piece types.
 */
package piece;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ConnectFourPiece extends GamePiece {
    
    /**
     * Constructor of ConnectFourPiece, calls  setColour() and setIcons()
     * @param col a String to set colour using setColour() of the superclass
     */
    public ConnectFourPiece(String col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: ConnectFourPiece() BEGIN");
        }
        
        SetColour(col);
        SetIcons();
        
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: ConnectFourPiece() END");
        }
    }
    
    /**
     * Accessor method to retrieve the ImageIcon of the piece
     * @return Icon depending on piece colour
     */
    public Icon GetIcon() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: getIcon() BEGIN");
        }
        
        if (GetColour().equals("yellow")) {
            if (test || m_test) {
                System.out.println("ConnectFourPiece :: getIcon() END");
            }
            
            return m_yellowpiece;
        } else {
            if (test || m_test) {
                System.out.println("ConnectFourPiece :: getIcon() END");
            }
            
            return m_redpiece;
        }
    }
    
    /**
     * Accessor method to set the ImageIcons of a piece
     * @return boolean on success
     * @throws NullPointerException
     */
    public boolean SetIcons() throws NullPointerException {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: setIcons() BEGIN");
        }
        
        String yellowImageURL = "yellow.png";
        String redImageURL = "red.png";
        
        try {
            m_yellowpiece = new ImageIcon(getClass().getResource(yellowImageURL));
            m_redpiece = new ImageIcon(getClass().getResource(redImageURL));
        } catch (NullPointerException e) {
            System.out.println("Images Not Found");
        }
        
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: setIcons() END");
        }
        
        return true;
    }
    
    // variable declarations
    /** store the yellow icon */
    private Icon m_yellowpiece;
    /** store the red icon */
    private Icon m_redpiece;
    /** Indicates whether to run tests */
    private boolean m_test = false;
}