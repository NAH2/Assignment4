package piece;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ConnectFourPiece extends GamePiece {
    
    public ConnectFourPiece(String col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: ConnectFourPiece() BEGIN");
        }
        
        setColour(col);
        setIcons();
        
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: ConnectFourPiece() END");
        }
    }
    
    public Icon getIcon() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: getIcon() BEGIN");
        }
        
        if (getColour().equals("yellow")) {
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
    
    public boolean setIcons() throws NullPointerException {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: setIcons() BEGIN");
        }
        
        try {
            m_yellowpiece = new ImageIcon(getClass().getResource("yellow.png"));
            m_redpiece = new ImageIcon(getClass().getResource("red.png"));
        } catch (NullPointerException e) {
            System.out.println("Images Not Found");
        }
        
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: setIcons() END");
        }
        
        return true;
    }
    
    // variable declarations
    private Icon m_yellowpiece;
    private Icon m_redpiece;
    private boolean m_test = false;
}